package gym.model.elements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity

@Table(name="Manager")
public class Manager {
	@Id
	@Column(name="Manager_ID")private int id;
	@Column(name="Manager_Name")private String name;
	@Column(name="Manager_Phone")private String phone;
	@Column(name="Manager_Info")private String info;
	@ManyToOne
	@JoinColumn(name="GYM_GYM_ID", referencedColumnName="GYM_ID")private Gym gym;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getInfo() {
		return info;
	}
	public Gym getGym() {
		return gym;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public void setGym(Gym gym) {
		this.gym = gym;
	}

	
}
