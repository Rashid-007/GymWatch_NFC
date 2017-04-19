package gym.view.frame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import gym.model.elements.Client;
import gym.model.gui.FactoryGUI;
import test.main.NFC;

public class Managment extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Frame frame;
	private static final String lbl = "Managment";
	
	private JScrollPane panel;
	private JTabbedPane tabbedPane;
	
	public Managment (Frame frame, JTabbedPane tabbedPane){
		this.frame = frame;
		this.tabbedPane = tabbedPane;
		createPartControl();
	}
	
	private void createPartControl(){
		panel = new JScrollPane();
		JPanel panel2 = new JPanel();
		
		panel2.setPreferredSize(new Dimension(640, 640));
	
		
		panel2.setLayout(null);

		JLabel ClientLbl = new JLabel("    Card management    ");
		ClientLbl.setFont(new Font("Serif", Font.PLAIN, 18));
		ClientLbl.setBounds(10, 40, 350, 30);
		panel2.add(ClientLbl);


		JLabel ClientGenderlLbl = new JLabel("Gender: ");
		ClientGenderlLbl.setFont(new Font("Serif", Font.PLAIN, 14));
		ClientGenderlLbl.setBounds(10, 70, 350, 18);
		panel2.add(ClientGenderlLbl);

		String[] genderList = { "Male", "Female"};
		JComboBox<String> ClientGender = new JComboBox(genderList);
		ClientGender.setBounds(10, 100, 150, 22);
		ClientGender.setEnabled(false);
		panel2.add(ClientGender);
		
		
		JTextField genderCard = new JTextField();
		genderCard.setBounds(350, 100, 300, 25);
		genderCard.setEditable(false);
		panel2.add(genderCard);
		
		

		JLabel ClientPhoneLbl = new JLabel("Phone: ");
		ClientPhoneLbl.setFont(new Font("Serif", Font.PLAIN, 14));
		ClientPhoneLbl.setBounds(10, 130, 350, 18);
		panel2.add(ClientPhoneLbl);

		JTextField ClientPhone = new JTextField();
		ClientPhone.setBounds(10, 160, 150, 25);
		ClientPhone.setEditable(false);
		panel2.add(ClientPhone);
		
		JTextField phoneCard = new JTextField();
		phoneCard.setBounds(350, 160, 300, 25);
		phoneCard.setEditable(false);
		panel2.add(phoneCard);
		
		
		
		
		
		JLabel ClientIDLbl = new JLabel("ID: ");
		ClientIDLbl.setFont(new Font("Serif", Font.PLAIN, 14));
		ClientIDLbl.setBounds(10, 250, 350, 18);
		panel2.add(ClientIDLbl);

		JTextField ClientID = new JTextField();
		ClientID.setBounds(10, 280, 300, 25);
		ClientID.setEditable(false);
		panel2.add(ClientID);
		
		
		JLabel ClientTypeSubLbl = new JLabel("Subscription Type: ");
		ClientTypeSubLbl.setFont(new Font("Serif", Font.PLAIN, 14));
		ClientTypeSubLbl.setBounds(10, 190, 350, 18);
		panel2.add(ClientTypeSubLbl);
		
		JTextField ClientTypeSub = new JTextField();
		ClientTypeSub.setBounds(10, 220, 150, 25);
		ClientTypeSub.setEditable(false);
		panel2.add(ClientTypeSub);

		
		JTextField subCard = new JTextField();
		subCard.setBounds(350, 220, 300, 25);
		subCard.setEditable(false);
		panel2.add(subCard);
		
		
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(10, 350, 50, 30);
		btnOk.setFont(new Font("Serif", Font.PLAIN, 12));
		panel2.add(btnOk);
		
		JButton btnOk2 = new JButton("SAVE TO CARD");
		btnOk2.setBounds(10, 400, 150, 30);
		btnOk2.setFont(new Font("Serif", Font.PLAIN, 12));
		panel2.add(btnOk2);
		
		btnOk2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				NFC nfc = new NFC();
				nfc.init();
				
				String gender = genderCard.getText();
				String phone = phoneCard.getText();
				String sub = subCard.getText();
				
				nfc.recordNew(gender, "01", "00");
				nfc.recordNew(phone, "02", "00");
				nfc.recordNew(sub, "03", "00");

		}
	});
		
		
btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				
				FactoryGUI f = new FactoryGUI();
				Client client = null;
				String fres = null;
				try {
					fres = f.getClientEmtyc().getId();
					client = f.getClientByID(fres);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ClientID.setText(fres);
				
				if(client.getGender().equals("male")){
					genderCard.setText("00000000000000000000000000000101");
					ClientGender.setSelectedIndex(0);
				}if(client.getGender().equals("female")){
					genderCard.setText("00000000000000000000000000000202");
					ClientGender.setSelectedIndex(1);
				}
				

				
				
				int sa = 0;
				try {
					sa = f.getSubByCID(client).getSubscriptionType().getId();
					subCard.setText("00000000000000000000000000000"+sa+""+sa+""+sa);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ClientPhone.setText(client.getPhone());
				phoneCard.setText("00000000000000000000"+client.getPhone());
				
				String z = null;
				try {
					z = f.getSubByCID(client).getSubscriptionType().getName();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ClientTypeSub.setText(z);

				
				System.out.println("FRES IS "+fres);
				
				
				
				
				
				
				
				
				
				panel2.repaint();  
		}
	});
		panel.setViewportView(panel2);
	
	}

	public Frame getFrame() {
		return frame;
	}

	public static String getLbl() {
		return lbl;
	}

	public JScrollPane getPanel() {
		return panel;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	public void setPanel(JScrollPane panel) {
		this.panel = panel;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}
	
}
