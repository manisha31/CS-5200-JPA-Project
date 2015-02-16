package mymealServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import mymealDAO.FeedBackDAO;
import mymealDAO.RestaurantDAO;
import mymealDTO.Feedback;
import mymealDTO.Restaurant;

/**
 * Servlet implementation class Restaurant
 */

public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RestaurantDAO rd = new RestaurantDAO();
		FeedBackDAO fd = new FeedBackDAO();
		List<Feedback> allFeedBack = null;  
		String idString = request.getParameter("id");
		Restaurant rest = null;
		if(null != idString){
			rest = rd.getRestaurantById(Integer.parseInt(idString));
		}
		try {
			allFeedBack = fd.getAllFeedback(rest.getRestaurant_id());
	
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute("selectedRestaurant", rest);
		request.getSession().setAttribute("selectedFeedback", allFeedBack);
		request.getRequestDispatcher("restaurantDetail.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RestaurantDAO rd = new RestaurantDAO();
		ArrayList<RestaurantServlet> refinedList = new ArrayList<>();
		List<Restaurant> rests = new ArrayList<Restaurant>();
		String zip =  request.getParameter("zip");
		//System.out.println(zip);
		String citySelected = request.getParameter("cityListDropDown");
		System.out.println(citySelected);
	        if (request.getParameter("submit1") != null) {
				try {
					rests = rd.getAllRestaurantsByCity(citySelected);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
	        } else if (request.getParameter("submit2") != null) {
	        	
				try {
					rests = rd.getAllRestaurantsByZipcode(zip);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        request.setAttribute("resSearch", rests);
            request.getRequestDispatcher("restaurantDisplay.jsp").forward(request, response);
	        
	}

}
