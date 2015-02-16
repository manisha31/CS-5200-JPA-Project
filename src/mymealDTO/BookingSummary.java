package mymealDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="booking_summary")
public class BookingSummary {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="booking_summary_id")
	int booking_summary_id;
	
	public int getBooking_summary_id() {
		return booking_summary_id;
	}

	public void setBooking_summary_id(int booking_summary_id) {
		this.booking_summary_id = booking_summary_id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public String getFor_date() {
		return for_date;
	}

	public void setFor_date(String for_date) {
		this.for_date = for_date;
	}

	public String getMeal_time() {
		return meal_time;
	}

	public void setMeal_time(String meal_time) {
		this.meal_time = meal_time;
	}

	@ManyToOne
    @JoinColumn(name="restaurant_id")
	Restaurant restaurant;
	
	@Column(name="for_date")
	String  for_date;
	
	@Column(name="meal_time")
	String meal_time;
	
	@Column(name="noOfseats")
	int no_Of_Seats;

	public int getNo_Of_Seats() {
		return no_Of_Seats;
	}

	public void setNo_Of_Seats(int no_Of_Seats) {
		this.no_Of_Seats = no_Of_Seats;
	}

}
