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

import com.mysql.jdbc.Statement;

import mymealDTO.Booking;
import mymealDTO.Customer;

public class CustomerDAO {
	
	EntityManagerFactory entityManagerFactory;

	public CustomerDAO() {
		entityManagerFactory = Persistence.createEntityManagerFactory("mymeal");
	}

	public List<Customer> getAllCustomer() throws ClassNotFoundException,
	SQLException {
EntityManager em = entityManagerFactory.createEntityManager();
String queryString = "from Customer c";
Query q = em.createQuery(queryString);
List<Customer> customers = q.getResultList();
return customers;
}
	
	public void insert(Customer c) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public Customer findByUsernameAndPassword(String username, String password){
		EntityManager em = entityManagerFactory.createEntityManager();
		String queryString = "from Customer c where c.user_name = :username and c.password = :pass";
		Query q = em.createQuery(queryString);
		q.setParameter("username", username);
		q.setParameter("pass", password);
		List<Customer> customers = q.getResultList();
		if(customers.size() > 0)
			return customers.get(0);
		else
			return null;	
	}
	

	

}
