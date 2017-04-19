package gym.model;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import gym.model.elements.Client;
import gym.model.elements.WebInfo;
import gym.model.gui.FactoryGUI;
import gym.view.frame.Frame;
import test.main.NFC;

public class GymWatchModel {

	FactoryGUI factoryGUI = new FactoryGUI();
	
	
	public boolean WebInfoCheck(String login, String password) throws SQLException{
		return factoryGUI.checkWebInfo(login, password);
	}
	
	public void newClientReg(Frame frame, String id, String name, String email, Date bday, String gender, String phone, String address) throws SQLException{
		Client client = new Client();
	
		
		
		client.setId(id);
		client.setName(name);
		client.setEmail(email);
		client.setBddate(bday);
		client.setGender(gender);
		client.setPhone(phone);
		client.setAddress(address);
		
		factoryGUI.deleteClient(id);
		
		factoryGUI.newClient(client);
		
		
		JOptionPane.showMessageDialog(frame.getFrame(), "CREATED");
		
		
		
	}
	
	
	
}
