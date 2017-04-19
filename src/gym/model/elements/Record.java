package gym.model.elements;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Record")
public class Record {
	@Id
	@Column(name="Timestamp")private Date timestamp;
	@ManyToOne
	@JoinColumn(name="Person_Person_ID", referencedColumnName="Client_ID")private Client client;
	@ManyToOne
	@JoinColumn(name="GYM_GYM_ID", referencedColumnName="GYM_ID")private Gym gym;
	public Date getTimestamp() {
		return timestamp;
	}
	public Client getClient() {
		return client;
	}
	public Gym getGym() {
		return gym;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setGym(Gym gym) {
		this.gym = gym;
	}
	
}
