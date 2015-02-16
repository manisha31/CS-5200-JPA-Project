package mymealDAO;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import mymealDTO.BookingSummary;

public class BookingSummaryDAO {
	
	EntityManagerFactory entityManagerFactory;

	public BookingSummaryDAO() {
		entityManagerFactory = Persistence.createEntityManagerFactory("mymeal");
	}

	public List<BookingSummary> getAllBookingSummary() throws ClassNotFoundException,
			SQLException {

		EntityManager em = entityManagerFactory.createEntityManager();
		String queryString = "from BookingSummary b";
		Query q = em.createQuery(queryString);
		List<BookingSummary> bookingSummary = q.getResultList();
		return bookingSummary;
	}

	public void insert(BookingSummary b) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("mymeal");
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}

}
