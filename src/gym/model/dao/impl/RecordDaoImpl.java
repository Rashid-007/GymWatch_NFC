package gym.model.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import gym.model.dao.RecordDao;
import gym.model.elements.Record;
import gym.model.util.HibernateUtil;

public class RecordDaoImpl implements RecordDao{
	@Override
	public void addRecord(Record Record) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(Record);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}
	}

	@Override
	public void deleteRecord(Record Record) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(Record);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}
	}

	@Override
	public Record getRecord(Date id) throws SQLException {
		Record result = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			result = (Record)session.get(Record.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}	
		return result;
	}

	@Override
	public List<Record> getRecords() throws SQLException {
		List<Record> Records = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Records = session.createCriteria(Record.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}	
		return Records;
	}
}
