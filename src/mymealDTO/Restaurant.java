package mymealDTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="restaurant")
public class Restaurant {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="restaurant_id")
	int restaurant_id;
	
	@Column(name="name")
	String name;
	
	@Column(name="city")
	String city;
	
	@Column(name="zipcode")
	String zipcode;
	
	@Column(name="restaurant_img")
	String restaurant_img;
	
	@Column(name="count_table_total")
	int count_table_total;
	
	@Column(name="count_table_available")
	int count_table_available;
	
	@Column(name="vegNonveg")
	boolean vegNonveg;
	


	public boolean isVegNonveg() {
		return vegNonveg;
	}

	public void setVegNonveg(boolean vegNonveg) {
		this.vegNonveg = vegNonveg;
	}

	public boolean isBar_available() {
		return bar_available;
	}

	public void setBar_available(boolean bar_available) {
		this.bar_available = bar_available;
	}

	public boolean isHome_delivery() {
		return home_delivery;
	}

	public void setHome_delivery(boolean home_delivery) {
		this.home_delivery = home_delivery;
	}

	public int getCost_for_two() {
		return cost_for_two;
	}

	public void setCost_for_two(int cost_for_two) {
		this.cost_for_two = cost_for_two;
	}

	@Column(name="bar_available")
	boolean bar_available;
	
	@Column(name="home_delivery")
	boolean home_delivery;
	
	@Column(name="approximate_cost")
	int cost_for_two;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="restaurant")
	List<Feedback> feedbacks;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="restaurant")
	List<Booking> bookings;


	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getRestaurant_img() {
		return restaurant_img;
	}

	public void setRestaurant_img(String restaurant_img) {
		this.restaurant_img = restaurant_img;
	}

	public int getCount_table_total() {
		return count_table_total;
	}

	public void setCount_table_total(int count_table_total) {
		this.count_table_total = count_table_total;
	}

	public int getCount_table_available() {
		return count_table_available;
	}

	public void setCount_table_available(int count_table_available) {
		this.count_table_available = count_table_available;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

}
