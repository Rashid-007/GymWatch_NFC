package gym.model.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import gym.model.dao.ClientDao;
import gym.model.elements.Client;
import gym.model.util.HibernateUtil;


public class ClientDaoImpl implements ClientDao{

	@Override
	public void addClient(Client client) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(client);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}
	}

	@Override
	public void deleteClient(Client client) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(client);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}
	}

	@Override
	public Client getClient(String id) throws SQLException {
		Client result = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			result = (Client)session.get(Client.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}	
		return result;
	}

	@Override
	public List<Client> getClients() throws SQLException {
		List<Client> clients = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			clients = session.createCriteria(Client.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}	
		return clients;
	}
}
