package mymealDTO;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="booking")
public class Booking {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="booking_id")
	int booking_id;
	
	@OneToOne
	@JoinColumn(name="restaurant_id")
	Restaurant restaurant;
	
	@ManyToOne
    @JoinColumn(name="customer")
	Customer customer;
	
	@Column(name="table_booked")
	int table_booked;
	
	@Column(name="b_date")
	Date b_date;
	
	@Column(name="booking_status")
	String booking_status;
	
	@Column(name="booking_date")
	String booking_date;
	
	@Column(name="lunchDinner")
	String lunchDinner;

	public String getLunchDinner() {
		return lunchDinner;
	}

	public void setLunchDinner(String lunchDinner) {
		this.lunchDinner = lunchDinner;
	}

	public String getBooking_date() {
		return booking_date;
	}

	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}


	public int getTable_booked() {
		return table_booked;
	}

	public void setTable_booked(int table_booked) {
		this.table_booked = table_booked;
	}

	public Date getB_date() {
		return b_date;
	}

	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}

	public String getBooking_status() {
		return booking_status;
	}

	public void setBooking_status(String booking_status) {
		this.booking_status = booking_status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}
