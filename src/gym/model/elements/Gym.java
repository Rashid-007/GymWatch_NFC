package gym.model.elements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GYM")
public class Gym {

	@Id
	@Column(name="GYM_ID")private int id;
	@Column(name="GYM_Name")private String name;
	@Column(name="GYM_Address")private String address;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
