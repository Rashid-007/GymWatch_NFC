package gym.model.dao;

import java.sql.SQLException;
import java.util.List;

import gym.model.elements.Manager;

public interface ManagerDao {

	public void addManager(Manager Manager)throws SQLException;
	public void deleteManager(Manager Manager)throws SQLException;
	public Manager getManager(int id)throws SQLException;
	public List<Manager> getManagers()throws SQLException;
}
