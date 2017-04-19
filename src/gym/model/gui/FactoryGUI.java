package gym.model.gui;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.criterion.Restrictions;

import gym.model.dao.ClientDao;
import gym.model.dao.CoachDao;
import gym.model.dao.GymDao;
import gym.model.dao.ManagerDao;
import gym.model.dao.RecordDao;
import gym.model.dao.SubscriptionDao;
import gym.model.dao.SubscriptionTypeDao;
import gym.model.dao.WebInfoDao;
import gym.model.elements.Client;
import gym.model.elements.Subscription;
import gym.model.elements.SubscriptionType;
import gym.model.elements.WebInfo;
import gym.model.general.Factory;
import gym.model.util.HibernateUtil;



public class FactoryGUI {

	Factory factory = Factory.getInstance();

	ClientDao clientDao = factory.getClientDao();
	CoachDao coachDao = factory.getCoachDao();
	GymDao gymDao = factory.getGymDao();
	ManagerDao managerDao = factory.getManagerDao();
	RecordDao recordDao = factory.getRecordDao();
	SubscriptionDao subscriptionDao = factory.getSubscriptionDao();
	SubscriptionTypeDao subscriptionTypeDao = factory.getSubscriptionTypeDao();
	WebInfoDao webInfoDao = factory.getWebInfoDao();


	
	public Client getClientByID(String id) throws SQLException{
		return clientDao.getClient(id);
	}
	
	public boolean checkWebInfo(String login, String pass) throws SQLException{
		List<WebInfo> webInfoStrings = webInfoDao.getWebInfos();
		for(WebInfo wi : webInfoStrings){
			String rl = wi.getLogin();
			String rp = wi.getPass();

			if(rl.equals(login)&&rp.equals(pass)){
				return true;
			}
		}
		return false;
	}
	
	public Client getClientEmty(){

		List<Client> cl = HibernateUtil.getSessionFactory().openSession().createCriteria(Client.class)
				.add( Restrictions.isNull("name"))
				.list();
		return cl.get(cl.size() - 1);
	}
	public Client getClientEmtyc() throws SQLException{

		List<WebInfo> cl = HibernateUtil.getSessionFactory().openSession().createCriteria(WebInfo.class)
				.add( Restrictions.isNull("login"))
				.list();
		WebInfo wi = cl.get(cl.size() - 1);
		deleteWebInfo(wi.getId());
		
		
		return getClientByID(wi.getId());
	}


	public void uTilheat(String r) throws SQLException{
		factory.webInfoDao.deleteWebInfo(webInfoDao.getWebInfo(r));
	}

	public void newClient(Client client) throws SQLException{
		clientDao.addClient(client);
	}

	public void newWebInfo(WebInfo client) throws SQLException{
		webInfoDao.addWebInfo(client);
	}

	public void deleteWebInfo(String id) throws SQLException{
		WebInfo c = factory.getWebInfoDao().getWebInfo(id);
		factory.getWebInfoDao().deleteWebInfo(c);
	}
	public void deleteClient(String id) throws SQLException{
		Client c = factory.getClientDao().getClient(id);
		factory.getClientDao().deleteClient(c);
	}
	public Subscription getSubByCID(Client client) throws SQLException{
		return factory.getSubscriptionDao().getSubscriptionBYClient(client);
	}
	public String getSubTypeNameByID(int l) throws SQLException{
		 SubscriptionType st = factory.subscriptionTypeDao.getSubscriptionType(l);
		 return st.getName();
	}
	
}
