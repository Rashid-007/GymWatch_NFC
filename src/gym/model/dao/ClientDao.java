package gym.model.dao;

import java.sql.SQLException;
import java.util.List;

import gym.model.elements.Client;

public interface ClientDao {
	
	public void addClient(Client client)throws SQLException;
	public void deleteClient(Client client)throws SQLException;
	public Client getClient(String id)throws SQLException;
	public List<Client> getClients()throws SQLException;
	
}
