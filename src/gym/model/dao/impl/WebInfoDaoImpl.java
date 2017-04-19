package gym.model.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import gym.model.dao.WebInfoDao;
import gym.model.elements.WebInfo;
import gym.model.util.HibernateUtil;

public class WebInfoDaoImpl implements WebInfoDao{
	@Override
	public void addWebInfo(WebInfo WebInfo) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(WebInfo);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}
	}

	@Override
	public void deleteWebInfo(WebInfo WebInfo) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(WebInfo);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}
	}

	@Override
	public WebInfo getWebInfo(String id) throws SQLException {
		WebInfo result = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			result = (WebInfo)session.get(WebInfo.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}	
		return result;
	}

	@Override
	public List<WebInfo> getWebInfos() throws SQLException {
		List<WebInfo> WebInfos = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			WebInfos = session.createCriteria(WebInfo.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if((session != null)&&(session.isOpen()))session.close();
		}	
		return WebInfos;
	}

	
}
