package gym.model.dao;

import java.sql.SQLException;
import java.util.List;

import gym.model.elements.Client;
import gym.model.elements.Subscription;

public interface SubscriptionDao {
	public void addSubscription(Subscription Subscription)throws SQLException;
	public void deleteSubscription(Subscription Subscription)throws SQLException;
	public Subscription getSubscription(long id)throws SQLException;
	public Subscription getSubscriptionBYClient(Client client)throws SQLException;
	public List<Subscription> getSubscriptions()throws SQLException;
}
