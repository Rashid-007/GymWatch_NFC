package gym.model.elements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Subscription_Type")
public class SubscriptionType {
	@Id
	@Column(name="Subscription_Type_ID")private int id;
	@Column(name="Subscription_Type_Name")private String name;
	@Column(name="Subscription_Type_PricePerMonth")private Double pricePerMonth;
	@Column(name="Subscription_Type_Description")private String desc;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Double getPricePerMonth() {
		return pricePerMonth;
	}
	public String getDesc() {
		return desc;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPricePerMonth(Double pricePerMonth) {
		this.pricePerMonth = pricePerMonth;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
