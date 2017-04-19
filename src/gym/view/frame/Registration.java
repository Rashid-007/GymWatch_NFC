package gym.view.frame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.enterprise.inject.Model;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.toedter.calendar.JDateChooser;

import gym.model.GymWatchModel;
import gym.model.elements.Client;
import gym.model.general.Factory;
import gym.model.gui.FactoryGUI;
import test.main.NFC;

public class Registration extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Frame frame;
	private static final String lbl = "Registration";

	private JScrollPane panel;
	private JTabbedPane tabbedPane;


	public Registration (Frame frame, JTabbedPane tabbedPane){
		this.frame = frame;
		this.tabbedPane = tabbedPane;
		createPartControl();
	}

	private void createPartControl(){
		NFC nfc = new NFC();
		nfc.init();
		nfc.scans();
		panel = new JScrollPane();
		JPanel panel2 = new JPanel();

		panel2.setPreferredSize(new Dimension(640, 640));

		panel2.setLayout(null);

		JLabel ClientLbl = new JLabel("    New Client    ");
		ClientLbl.setFont(new Font("Serif", Font.PLAIN, 18));
		ClientLbl.setBounds(10, 10, 350, 30);
		panel2.add(ClientLbl);

		JLabel ClientNameLbl = new JLabel("Fullname: ");
		ClientNameLbl.setFont(new Font("Serif", Font.PLAIN, 14));
		ClientNameLbl.setBounds(10, 50, 350, 18);
		panel2.add(ClientNameLbl);

		JTextField clientName = new JTextField();
		clientName.setBounds(10, 75, 150, 25);
		panel2.add(clientName);

		JLabel ClientEmailLbl = new JLabel("Email: ");
		ClientEmailLbl.setFont(new Font("Serif", Font.PLAIN, 14));
		ClientEmailLbl.setBounds(10, 100, 350, 18);
		panel2.add(ClientEmailLbl);

		JTextField clientEmail = new JTextField();
		clientEmail.setBounds(10, 125, 150, 25);
		panel2.add(clientEmail);

		JLabel ClientBDaylLbl = new JLabel("Date of birth: ");
		ClientBDaylLbl.setFont(new Font("Serif", Font.PLAIN, 14));
		ClientBDaylLbl.setBounds(10, 150, 350, 18);
		panel2.add(ClientBDaylLbl);

		JDateChooser ClientBDay = new JDateChooser();
		ClientBDay.setBounds(10, 170, 150, 18);
		panel2.add(ClientBDay);

		JLabel ClientGenderlLbl = new JLabel("Gender: ");
		ClientGenderlLbl.setFont(new Font("Serif", Font.PLAIN, 14));
		ClientGenderlLbl.setBounds(10, 195, 350, 18);
		panel2.add(ClientGenderlLbl);

		String[] genderList = { "Male", "Female"};
		JComboBox<String> ClientGender = new JComboBox(genderList);
		ClientGender.setBounds(10, 220, 150, 22);
		panel2.add(ClientGender);

		JLabel ClientPhoneLbl = new JLabel("Phone: ");
		ClientPhoneLbl.setFont(new Font("Serif", Font.PLAIN, 14));
		ClientPhoneLbl.setBounds(10, 245, 350, 18);
		panel2.add(ClientPhoneLbl);

		JTextField ClientPhone = new JTextField();
		ClientPhone.setBounds(10, 270, 150, 25);
		panel2.add(ClientPhone);

		JLabel ClientAddressLbl = new JLabel("Address: ");
		ClientAddressLbl.setFont(new Font("Serif", Font.PLAIN, 14));
		ClientAddressLbl.setBounds(10, 295, 350, 18);
		panel2.add(ClientAddressLbl);

		JTextField ClientAddress = new JTextField();
		ClientAddress.setBounds(10, 320, 150, 25);
		panel2.add(ClientAddress);

		JLabel ClientIDLbl = new JLabel("ID: ");
		ClientIDLbl.setFont(new Font("Serif", Font.PLAIN, 14));
		ClientIDLbl.setBounds(10, 345, 350, 18);
		panel2.add(ClientIDLbl);

		JTextField ClientID = new JTextField();
		ClientID.setBounds(10, 370, 300, 25);
		ClientID.setEditable(false);
		panel2.add(ClientID);


		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(10, 450, 50, 30);
		btnOk.setFont(new Font("Serif", Font.PLAIN, 12));
		panel2.add(btnOk);

		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					frame.getModel().newClientReg(frame, ClientID.getText(), clientName.getText(), clientEmail.getText(), ClientBDay.getDate(), ClientGender.getSelectedItem().toString(), ClientPhone.getText(), ClientAddress.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		clientName.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				warn();
			}
			public void removeUpdate(DocumentEvent e) {
				
			}
			public void insertUpdate(DocumentEvent e) {
				warn();
			}

			public void warn() {

				if(clientName.getText().length()<2){
					FactoryGUI f = new FactoryGUI();
					String fres = f.getClientEmty().getId();
					ClientID.setText(fres);
					
					System.out.println("FRES IS "+fres);
					panel2.repaint();
					
				}    
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
