package mymealDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mymealDTO.Booking;
import mymealDTO.Restaurant;

public class RestaurantDAO {
	EntityManagerFactory entityManagerFactory;

	public RestaurantDAO() {
		entityManagerFactory = Persistence.createEntityManagerFactory("mymeal");
	}

	/*public List<Restaurant> getAllRestaurants()
			throws ClassNotFoundException, SQLException {
		EntityManager em = entityManagerFactory.createEntityManager();
		String queryString = "from Restaurant r";
		Query q = em.createQuery(queryString);
		List<Restaurant> allRestaurants = q.getResultList();
		return allRestaurants;

	}*/
	public List<Restaurant> getAllRestaurantsByZipcode(String zipcode)
			throws ClassNotFoundException, SQLException {
		EntityManager em = entityManagerFactory.createEntityManager();
		String queryString = "from Restaurant r where r.zipcode = :zip";
		Query q = em.createQuery(queryString);
		q.setParameter("zip", zipcode);
		List<Restaurant> allRestaurants = q.getResultList();
		return allRestaurants;

	}
	
	public List<Restaurant> getAllRestaurantsByCity(String city)
			throws ClassNotFoundException, SQLException {
		EntityManager em = entityManagerFactory.createEntityManager();
		String queryString = "from Restaurant r where r.city = :city";
		Query q = em.createQuery(queryString);
		q.setParameter("city", city);
		List<Restaurant> allRestaurants = q.getResultList();
		return allRestaurants;

	}
	
	public List<String> getAllCities(){
		EntityManager em = entityManagerFactory.createEntityManager();
		String queryString = "select distinct r.city from Restaurant r";
		Query q = em.createQuery(queryString);
		List<String> cities = q.getResultList();
		return cities;		
	}
	
	public Restaurant getRestaurantById(int id){
		EntityManager em = entityManagerFactory.createEntityManager();
		return em.find(Restaurant.class, id);
	}
//	String queryString = "from Restaurant r where r.zipcode = :zip";
//	Query q = em.createQuery(queryString);
//	q.setParameter("zip", 1234);


	public void insert(Restaurant r) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Restaurant r) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(r);
		em.getTransaction().commit();
		em.close();
	}

}
