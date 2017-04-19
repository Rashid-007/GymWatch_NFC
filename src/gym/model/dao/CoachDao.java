package gym.model.dao;

import java.sql.SQLException;
import java.util.List;

import gym.model.elements.Coach;

public interface CoachDao {

	public void addCoach(Coach Coach)throws SQLException;
	public void deleteCoach(Coach Coach)throws SQLException;
	public Coach getCoach(int id)throws SQLException;
	public List<Coach> getCoachs()throws SQLException;
	
}
