package gym.model.elements;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Subscription")
public class Subscription {
	@Id
	@Column(name="Subscription_ID")@GeneratedValue(strategy=GenerationType.AUTO)private long id;
	@Column(name="Subscription_Start")private Date start;
	@Column(name="Subscription_Finish")private Date finish;
	@Column(name="Subscription_Month")private int months;
	@Column(name="Subscription_Price")private double price;
	@ManyToOne
	@JoinColumn(name="Subscription_Type", referencedColumnName="Subscription_Type_ID")private SubscriptionType subscriptionType;
	@ManyToOne
	@JoinColumn(name="GYM_ID", referencedColumnName="GYM_ID")private Gym gym;
	@ManyToOne
	@JoinColumn(name="Client_ID", referencedColumnName="Client_ID")private Client client;
	@ManyToOne
	@JoinColumn(name="Coach_ID", referencedColumnName="Coach_ID")private Coach coach;
	public long getId() {
		return id;
	}
	public Date getStart() {
		return start;
	}
	public Date getFinish() {
		return finish;
	}
	public int getMonths() {
		return months;
	}
	public double getPrice() {
		return price;
	}
	public SubscriptionType getSubscriptionType() {
		return subscriptionType;
	}
	public Gym getGym() {
		return gym;
	}
	public Client getClient() {
		return client;
	}
	public Coach getCoach() {
		return coach;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public void setFinish(Date finish) {
		this.finish = finish;
	}
	public void setMonths(int months) {
		this.months = months;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setSubscriptionType(SubscriptionType subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	public void setGym(Gym gym) {
		this.gym = gym;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	
}
