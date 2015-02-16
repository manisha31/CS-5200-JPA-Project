package mymealDAO;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mymealDTO.Booking;
import mymealDTO.Feedback;
import mymealDTO.Restaurant;

public class FeedBackDAO {
	EntityManagerFactory entityManagerFactory;
	public FeedBackDAO() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "mymeal" );
	}
	
	public void insert(Feedback feedback) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(feedback);
		
		em.getTransaction().commit();
		
		em.close();
		
	}
	

	public List<Feedback> getAllFeedback(int restaurant_id)
			throws ClassNotFoundException, SQLException {
		EntityManager em = entityManagerFactory.createEntityManager();
		String queryString = "from Feedback f where f.restaurant.restaurant_id = :rest";
		Query q = em.createQuery(queryString);
		q.setParameter("rest", restaurant_id);
		List<Feedback> allFeedbacks = q.getResultList();
		return allFeedbacks;

	}
	
	public void delete_feedback(Feedback f){
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("mymeal");
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.remove(f);
		em.getTransaction().commit();
		em.close();
	}
	
	
	
}
