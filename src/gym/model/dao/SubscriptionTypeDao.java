package gym.model.dao;

import java.sql.SQLException;
import java.util.List;

import gym.model.elements.SubscriptionType;

public interface SubscriptionTypeDao {
	
	public void addSubscriptionType(SubscriptionType SubscriptionType)throws SQLException;
	public void deleteSubscriptionType(SubscriptionType SubscriptionType)throws SQLException;
	public SubscriptionType getSubscriptionType(int id) throws SQLException;
	public List<SubscriptionType> getSubscriptionTypes()throws SQLException;
	
}
