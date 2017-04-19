package gym.model.elements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WEB_INFO")
public class WebInfo {
	@Id
	@Column(name="ID")private String id;
	@Column(name="PASSWORD")private String pass;
	@Column(name="LOGIN")private String login;
	public String getId() {
		return id;
	}
	public String getPass() {
		return pass;
	}
	public String getLogin() {
		return login;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
}
