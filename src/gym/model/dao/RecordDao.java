package gym.model.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import gym.model.elements.Record;

public interface RecordDao {

	public void addRecord(Record Record)throws SQLException;
	public void deleteRecord(Record Record)throws SQLException;
	public Record getRecord(Date id)throws SQLException;
	public List<Record> getRecords()throws SQLException;
}
