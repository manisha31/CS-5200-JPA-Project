package mymealServlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mymealDAO.FeedBackDAO;
import mymealDTO.Customer;
import mymealDTO.Feedback;
import mymealDTO.Restaurant;

/**
 * Servlet implementation class FeedBackServlet
 */
public class FeedBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FeedBackDAO feedBackDAO = new FeedBackDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedBackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Restaurant rest = (Restaurant)request.getSession(false).getAttribute("selectedRestaurant");
		Customer cust = (Customer) request.getSession(false).getAttribute("loggedUser");
		if (request.getParameter("addFeedback") != null) {
			String feedBack = request.getParameter("feedBack");
			System.out.println("Feed Back given : "+feedBack + " for "+rest.getName()+ " by "+cust.getUser_name());
			Feedback feed = new Feedback();
			feed.setFeedback(feedBack);
			feed.setDate_submitted(new Date());
			feed.setCustomer(cust);
			feed.setRestaurant(rest);
			feedBackDAO.insert(feed);
			 response.sendRedirect("http://localhost:8080/mymeal/");
			 //request.getRequestDispatcher("restaurantDetail.jsp").forward(request, response);
			//response.sendRedirect("http://localhost:8080/mymeal/Restaurant?id=1"+rest.getRestaurant_id());
		}
	}

}
