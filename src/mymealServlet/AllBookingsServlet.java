package mymealServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mymealDAO.BookingDAO;
import mymealDTO.Booking;
import mymealDTO.Customer;
import mymealDTO.Restaurant;

/**
 * Servlet implementation class DeleteBookingServlet
 */
public class AllBookingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public  AllBookingsServlet() {
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
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("seeBooking") != null){
			Restaurant rest = (Restaurant)request.getSession(false).getAttribute("selectedRestaurant");
			Customer cust = (Customer) request.getSession(false).getAttribute("loggedUser");
			BookingDAO bDao = new BookingDAO();
			List<Booking> allBooking = null;
			try {
				allBooking = bDao.getAllBooking();
				//System.out.println(allBooking.size());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(allBooking.get(0));
			ArrayList<Booking> filterList= new ArrayList<>();
			for(int i = 0 ;i<allBooking.size();i++){
				//System.out.println(allBooking.get(i).getBooking_id());
				if(allBooking.get(i).getCustomer().getUser_name().equals(cust.getUser_name())){
					filterList.add(allBooking.get(i));
				}
			}
			request.setAttribute("BookingList", filterList);
			request.getRequestDispatcher("allBookings.jsp").forward(request, response);
		}
		
		
	}

}
