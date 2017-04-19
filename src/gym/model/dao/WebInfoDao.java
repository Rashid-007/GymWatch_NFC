package gym.model.dao;

import java.sql.SQLException;
import java.util.List;

import gym.model.elements.WebInfo;

public interface WebInfoDao {
	public void addWebInfo(WebInfo WebInfo)throws SQLException;
	public void deleteWebInfo(WebInfo WebInfo)throws SQLException;
	public WebInfo getWebInfo(String id)throws SQLException;
	public List<WebInfo> getWebInfos()throws SQLException;
}
