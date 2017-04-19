package gym.model.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;


import gym.model.dao.ManagerDao;
import gym.model.elements.Manager;
import gym.model.util.HibernateUtil;

public class ManagerDaoImpl implements ManagerDao{
	@Override
	public void addManager(Manager Manager) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(Manager);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}
	}

	@Override
	public void deleteManager(Manager Manager) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(Manager);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}
	}

	@Override
	public Manager getManager(int id) throws SQLException {
		Manager result = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			result = (Manager)session.get(Manager.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}	
		return result;
	}

	@Override
	public List<Manager> getManagers() throws SQLException {
		List<Manager> Managers = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Managers = session.createCriteria(Manager.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}	
		return Managers;
	}
}
