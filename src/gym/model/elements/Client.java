package gym.model.elements;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client {
	
	@Id
	@Column(name="Client_ID")private String id;
	@Column(name="Client_email")private String email;
	@Column(name="Client_Name")private String name;
	@Column(name="Client_BirthDate")private Date bddate;
	@Column(name="Client_Gender")private String gender;
	@Column(name="Client_Phone")private String phone;
	@Column(name="Client_Address")private String address;

	public String getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public Date getBddate() {
		return bddate;
	}
	public String getGender() {
		return gender;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBddate(Date bddate) {
		this.bddate = bddate;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
