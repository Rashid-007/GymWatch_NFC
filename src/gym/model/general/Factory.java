package gym.model.general;


import gym.model.dao.ClientDao;
import gym.model.dao.CoachDao;
import gym.model.dao.GymDao;
import gym.model.dao.ManagerDao;
import gym.model.dao.RecordDao;
import gym.model.dao.SubscriptionDao;
import gym.model.dao.SubscriptionTypeDao;
import gym.model.dao.WebInfoDao;
import gym.model.dao.impl.ClientDaoImpl;
import gym.model.dao.impl.CoachDaoImpl;
import gym.model.dao.impl.GymDaoImpl;
import gym.model.dao.impl.ManagerDaoImpl;
import gym.model.dao.impl.RecordDaoImpl;
import gym.model.dao.impl.SubscriptionDaoImpl;
import gym.model.dao.impl.SubscriptionTypeDaoImpl;
import gym.model.dao.impl.WebInfoDaoImpl;

public class Factory {
	public static Factory instance = new Factory();
	public ClientDao clientDao;
	public CoachDao coachDao;
	public GymDao gymDao;
	public ManagerDao managerDao;
	public RecordDao recordDao;
	public SubscriptionDao subscriptionDao;
	public SubscriptionTypeDao subscriptionTypeDao;
	public WebInfoDao webInfoDao;
	
	private Factory(){ }

	public static Factory getInstance(){
		return Factory.instance;
	}

	public ClientDao getClientDao() {
		if(clientDao == null)clientDao = new ClientDaoImpl();
		return clientDao;
	}

	public CoachDao getCoachDao() {
		if(coachDao == null)coachDao = new CoachDaoImpl();
		return coachDao;
	}

	public GymDao getGymDao() {
		if(gymDao == null)gymDao = new GymDaoImpl();
		return gymDao;
	}

	public ManagerDao getManagerDao() {
		if(managerDao == null)managerDao = new ManagerDaoImpl();
		return managerDao;
	}

	public RecordDao getRecordDao() {
		if(recordDao == null)recordDao = new RecordDaoImpl();
		return recordDao;
	}

	public SubscriptionDao getSubscriptionDao() {
		if(subscriptionDao == null)subscriptionDao = new SubscriptionDaoImpl();
		return subscriptionDao;
	}

	public SubscriptionTypeDao getSubscriptionTypeDao() {
		if(subscriptionTypeDao == null)subscriptionTypeDao = new SubscriptionTypeDaoImpl();
		return subscriptionTypeDao;
	}

	public WebInfoDao getWebInfoDao() {
		if(webInfoDao == null)webInfoDao = new WebInfoDaoImpl();
		return webInfoDao;
	}
	
}
