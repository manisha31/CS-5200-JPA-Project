package mymealDTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="feedback_id")
	int feedbackId;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	Customer customer;
	
	@Column(name="feedback")
	String feedback;
	
	@Column(name="date_submitted")
	Date date_submitted;
	
	@ManyToOne
    @JoinColumn(name="restaurant_id")
	Restaurant restaurant;
	
public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Date getDate_submitted() {
		return date_submitted;
	}

	public void setDate_submitted(Date date_submitted) {
		this.date_submitted = date_submitted;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
