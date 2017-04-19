package gym.model.dao;

import java.sql.SQLException;
import java.util.List;

import gym.model.elements.Gym;

public interface GymDao {

	public void addGym(Gym Gym)throws SQLException;
	public void deleteGym(Gym Gym)throws SQLException;
	public Gym getGym(int id)throws SQLException;
	public List<Gym> getGyms()throws SQLException;
	
}
