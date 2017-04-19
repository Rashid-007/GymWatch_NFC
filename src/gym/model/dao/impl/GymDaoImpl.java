package gym.model.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import gym.model.dao.GymDao;
import gym.model.elements.Gym;
import gym.model.util.HibernateUtil;

public class GymDaoImpl implements GymDao{
	@Override
	public void addGym(Gym Gym) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(Gym);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}
	}

	@Override
	public void deleteGym(Gym Gym) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(Gym);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}
	}

	@Override
	public Gym getGym(int id) throws SQLException {
		Gym result = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			result = (Gym)session.get(Gym.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}	
		return result;
	}

	@Override
	public List<Gym> getGyms() throws SQLException {
		List<Gym> Gyms = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Gyms = session.createCriteria(Gym.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}	
		return Gyms;
	}
}
