package gym.model.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import gym.model.dao.SubscriptionTypeDao;
import gym.model.elements.SubscriptionType;
import gym.model.util.HibernateUtil;

public class SubscriptionTypeDaoImpl implements SubscriptionTypeDao{
	@Override
	public void addSubscriptionType(SubscriptionType SubscriptionType) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(SubscriptionType);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}
	}

	@Override
	public void deleteSubscriptionType(SubscriptionType SubscriptionType) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(SubscriptionType);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}
	}

	@Override
	public SubscriptionType getSubscriptionType(int id) throws SQLException {
		SubscriptionType result = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			result = (SubscriptionType)session.get(SubscriptionType.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}	
		return result;
	}

	@Override
	public List<SubscriptionType> getSubscriptionTypes() throws SQLException {
		List<SubscriptionType> SubscriptionTypes = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			SubscriptionTypes = session.createCriteria(SubscriptionType.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}	
		return SubscriptionTypes;
	}


	
}
