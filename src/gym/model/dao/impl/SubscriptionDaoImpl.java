package gym.model.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import gym.model.dao.SubscriptionDao;
import gym.model.elements.Client;
import gym.model.elements.Subscription;
import gym.model.util.HibernateUtil;

public class SubscriptionDaoImpl implements SubscriptionDao{
	@Override
	public void addSubscription(Subscription Subscription) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(Subscription);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}
	}

	@Override
	public void deleteSubscription(Subscription Subscription) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(Subscription);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}
	}

	@Override
	public Subscription getSubscription(long id) throws SQLException {
		Subscription result = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			result = (Subscription)session.get(Subscription.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}	
		return result;
	}

	@Override
	public List<Subscription> getSubscriptions() throws SQLException {
		List<Subscription> Subscriptions = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Subscriptions = session.createCriteria(Subscription.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}	
		return Subscriptions;
	}


	@Override
	public Subscription getSubscriptionBYClient(Client client) throws SQLException {
		Subscription subClient = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Subscription WHERE client_id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", client.getId());
			List<Subscription> listOfSubs = query.getResultList();
			
			for(Object sub : listOfSubs){
				subClient = (Subscription)sub;
			}
			return subClient;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}
		return subClient;	
		
	}

}
