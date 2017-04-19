package test.main;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.smartcardio.CardException;
import javax.swing.JOptionPane;

import org.nfctools.mf.MfCardListener;
import org.nfctools.mf.MfReaderWriter;
import org.nfctools.mf.card.MfCard;

import eu.verdelhan.acr122urw.Acr122Device;
import eu.verdelhan.acr122urw.Acr122Manager;
import eu.verdelhan.acr122urw.HexUtils;
import eu.verdelhan.acr122urw.MifareUtils;
import gym.model.elements.Client;
import gym.model.elements.WebInfo;
import gym.model.gui.FactoryGUI;

public class NFC {
	private static Acr122Device acr122;
	private String res;
	

	public void scan(){
		String[] c = {"--dump", "FFFFFFFFFFFF"};
		try {
			dumpCards(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void scans(){
		String[] c = {"--dump", "FFFFFFFFFFFF"};
		try {
			dumpCard(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void scansCheck(){
		String[] c = {"--dump", "FFFFFFFFFFFF"};
		try {
			dumpCardCheck(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void fin(){
		close();
	}
	public void recordNew(String data, String sector, String block){
		String[] w = {"--write", sector, block, "FFFFFFFFFFFF", data};
		try {
			writeToCards(w);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void init(){
		try {
			acr122 = new Acr122Device();
			open();
		} catch (RuntimeException re) {
			System.out.println("No ACR122 reader found.");
			return;
		}
	}
	private static void open(){
		try {
			acr122.open();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(){
		try {
			acr122.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void dumpCards(String[] c) throws IOException {
		// Building the list of keys

		final List<String> keys = new ArrayList<>();
		for (int i = 1; i < c.length; i++) {
			String k = c[i].toUpperCase();
			if (MifareUtils.isValidMifareClassic1KKey(k)) {
				keys.add(k);
			}
		}
		// Adding the common keys
		keys.addAll(MifareUtils.COMMON_MIFARE_CLASSIC_1K_KEYS);
		
		
		
		
		// Card listener for dump
	
		@SuppressWarnings("deprecation")
		MfCardListener listener = new MfCardListener() {
			@Override
			public void cardDetected(MfCard mfCard, MfReaderWriter mfReaderWriter) throws IOException {
				printCardInfo(mfCard);
				
				try {
					MifareUtils.dumpMifareClassic1KCard(mfReaderWriter, mfCard, keys);
				} catch (CardException ce) {
					System.out.println("Card removed or not present.");
				}
			}


		};

		// Start listening


		acr122.listen(listener);



	}
	
	private static void dumpCardCheck(String[] c) throws IOException {
		// Building the list of keys

		final List<String> keys = new ArrayList<>();
		for (int i = 1; i < c.length; i++) {
			String k = c[i].toUpperCase();
			if (MifareUtils.isValidMifareClassic1KKey(k)) {
				keys.add(k);
			}
		}
		// Adding the common keys
		keys.addAll(MifareUtils.COMMON_MIFARE_CLASSIC_1K_KEYS);
		
		
		
		
		// Card listener for dump
	
		@SuppressWarnings("deprecation")
		MfCardListener listener = new MfCardListener() {
			@Override
			public void cardDetected(MfCard mfCard, MfReaderWriter mfReaderWriter) throws IOException {
				printCardInfo(mfCard);
				try {
					System.out.println("C_ID :"+MifareUtils.getBlockZero(mfReaderWriter, mfCard, keys));
					FactoryGUI f = new FactoryGUI();
					WebInfo c = new WebInfo();
					c.setId(MifareUtils.getBlockZero(mfReaderWriter, mfCard, keys));
					f.newWebInfo(c);
				} catch (CardException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}


		};

		// Start listening


		acr122.listen(listener);



	}
	
	
	
	
	private static void dumpCard(String[] c) throws IOException {
		// Building the list of keys

		final List<String> keys = new ArrayList<>();
		for (int i = 1; i < c.length; i++) {
			String k = c[i].toUpperCase();
			if (MifareUtils.isValidMifareClassic1KKey(k)) {
				keys.add(k);
			}
		}
		// Adding the common keys
		keys.addAll(MifareUtils.COMMON_MIFARE_CLASSIC_1K_KEYS);
		
		
		
		
		// Card listener for dump
	
		@SuppressWarnings("deprecation")
		MfCardListener listener = new MfCardListener() {
			@Override
			public void cardDetected(MfCard mfCard, MfReaderWriter mfReaderWriter) throws IOException {
				printCardInfo(mfCard);
				try {
					System.out.println("C_ID :"+MifareUtils.getBlockZero(mfReaderWriter, mfCard, keys));
					FactoryGUI f = new FactoryGUI();
					Client c = new Client();
					c.setId(MifareUtils.getBlockZero(mfReaderWriter, mfCard, keys));
					f.newClient(c);
				} catch (CardException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}


		};

		// Start listening


		acr122.listen(listener);



	}

	/**
	 * Writes to cards.
	 * @param args the arguments of the write command
	 */
	private static void writeToCards(String[] c) throws IOException {
		// Checking arguments
		if (c.length != 5) {
			printHelpAndExit();
		}

		final String sector = c[1];
		final String block = c[2];
		final String key = c[3].toUpperCase();
		final String data = c[4].toUpperCase();
		if (!MifareUtils.isValidMifareClassic1KSectorIndex(sector)
				|| !MifareUtils.isValidMifareClassic1KBlockIndex(block)
				|| !MifareUtils.isValidMifareClassic1KKey(key)
				|| !HexUtils.isHexString(data)) {
			printHelpAndExit();
		}

		final int sectorId = Integer.parseInt(sector);
		final int blockId = Integer.parseInt(block);

		// Card listener for writing
		MfCardListener listener = new MfCardListener() {
			@Override
			public void cardDetected(MfCard mfCard, MfReaderWriter mfReaderWriter) throws IOException {
				printCardInfo(mfCard);
				try {
					MifareUtils.writeToMifareClassic1KCard(mfReaderWriter, mfCard, sectorId, blockId, key, data);
				} catch (CardException ce) {
					System.out.println("Card removed or not present.");
				}finally {
					System.out.println("Operation is complited");
				}
			}
		};

		// Start listening
		acr122.listen(listener);
	}

	/**
	 * Prints help and exits.
	 */
	private static void printHelpAndExit() {

	}

	private static void printCardInfo(MfCard card) {
		System.out.println("Card detected: "
				+ card.getTagType().toString() + " "
				+ card.toString());
	}

	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}

}
