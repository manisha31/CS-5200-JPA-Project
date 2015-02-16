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

public class BookingDAO {

	EntityManagerFactory entityManagerFactory;

	public BookingDAO() {
		entityManagerFactory = Persistence.createEntityManagerFactory("mymeal");
	}

	public List<Booking> getAllBooking() throws ClassNotFoundException,
			SQLException {

		EntityManager em = entityManagerFactory.createEntityManager();
		String queryString = "from Booking b";
		Query q = em.createQuery(queryString);
		List<Booking> bookings = q.getResultList();
		return bookings;
	}

	public void insert(Booking b) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("mymeal");
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public void delete_booking(Booking b){
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("mymeal");
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.remove(b);
		em.getTransaction().commit();
		em.close();
	}

}
