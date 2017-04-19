package gym.model.gui;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import gym.model.elements.Client;
import gym.model.elements.Coach;
import gym.model.elements.Gym;
import gym.model.elements.Manager;
import gym.model.elements.Record;
import gym.model.elements.Subscription;
import gym.model.elements.SubscriptionType;
import gym.model.elements.WebInfo;

public class testDB {

	public static void main(String[] args) throws SQLException {
		
		FactoryGUI factory = new FactoryGUI();
		
		
		
		
		Client client = factory.getClientByID("1000000003");
		Subscription sub = (Subscription) factory.subscriptionDao.getSubscriptionBYClient(client);
		
		System.out.println(sub.getSubscriptionType().getName());
		
		System.out.println(sub.getId());
		
	}

}
