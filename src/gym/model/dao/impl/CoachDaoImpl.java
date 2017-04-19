package gym.model.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import gym.model.dao.CoachDao;
import gym.model.elements.Coach;
import gym.model.util.HibernateUtil;

public class CoachDaoImpl implements CoachDao{
	@Override
	public void addCoach(Coach Coach) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(Coach);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}
	}

	@Override
	public void deleteCoach(Coach Coach) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(Coach);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}
	}

	@Override
	public Coach getCoach(int id) throws SQLException {
		Coach result = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			result = (Coach)session.get(Coach.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}	
		return result;
	}

	@Override
	public List<Coach> getCoachs() throws SQLException {
		List<Coach> Coachs = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Coachs = session.createCriteria(Coach.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}	
		return Coachs;
	}
}
