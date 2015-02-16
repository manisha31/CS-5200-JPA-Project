package mymealServlet;

import java.io.IOException;

import javassist.expr.NewArray;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;



import mymealDAO.BookingDAO;
import mymealDAO.BookingSummaryDAO;
import mymealDAO.RestaurantDAO;
import mymealDTO.Booking;
import mymealDTO.BookingSummary;
import mymealDTO.Customer;
import mymealDTO.Restaurant;

/**
 * Servlet implementation class BookingServlet
 */
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Customer cust =  new Customer();
	Restaurant rest = new Restaurant();
	int bookings;
	String bookingDate = null;
	String lunchDinner  = null;
	//int doBooking=1;
	//int viewBooking=1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookingString = request.getParameter("bookings");
		bookingDate = request.getParameter("bookingDate");
		lunchDinner = request.getParameter("LunchDinner");
		List<BookingSummary> listSummary = null;
		//doBooking =0;
		//System.out.println("setting");
		//System.out.println(lunchDinner);
		bookings = Integer.parseInt(bookingString);
		rest = (Restaurant)request.getSession(false).getAttribute("selectedRestaurant");
		cust = (Customer) request.getSession(false).getAttribute("loggedUser");
		BookingDAO bDao = new BookingDAO();
		int rest_id = rest.getRestaurant_id();
		BookingSummaryDAO bookingSummaryDAO = new BookingSummaryDAO();
		try {
			listSummary = bookingSummaryDAO.getAllBookingSummary();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("List of booking wsumamry : "+listSummary.size());
		int seat_Available =0 ;
		for(int i= 0;i<listSummary.size();i++){
			if(bookingDate.equals(listSummary.get(i).getFor_date()) & lunchDinner.equals(listSummary.get(i).getMeal_time()) & (rest_id==listSummary.get(i).getRestaurant().getRestaurant_id())){
			seat_Available = listSummary.get(i).getNo_Of_Seats();
			}
		}
		RestaurantDAO rDao = new RestaurantDAO();
		BookingSummaryDAO bsDao = new BookingSummaryDAO();
		BookingSummary bs = new BookingSummary();
		if(seat_Available != 0){
		if(bookings <= (rest.getCount_table_total() - seat_Available)){
			System.out.println("Seat Available " + seat_Available);
			//rest.setCount_table_available(rest.getCount_table_available() - bookings);
			request.getSession(false).setAttribute("selectedRestaurant", rest);
			rDao.update(rest);
			Booking booking = new Booking();
			booking.setB_date(new Date());
			booking.setBooking_status("BOOKED");
			booking.setRestaurant(rest);
			booking.setCustomer(cust);
			booking.setTable_booked(bookings);
			booking.setBooking_date(bookingDate);
			booking.setLunchDinner(lunchDinner);
			bs.setFor_date(bookingDate);
			bs.setMeal_time(lunchDinner);
			bs.setNo_Of_Seats(bookings);
			bs.setRestaurant(rest);
			bDao.insert(booking);
			bsDao.insert(bs);
			request.setAttribute("Cust", cust);
			request.setAttribute("Rest", rest);
			request.setAttribute("booking", booking);
			request.getRequestDispatcher("ConfirmBooking.jsp").forward(request, response);
			sendMail();
		}
		else {
			System.out.println(":::" + seat_Available);
			request.setAttribute("message", "Sorry, Seats are not available");
			request.getRequestDispatcher("Booking.jsp").forward(request, response);

		}
		
		} 

		if(seat_Available == 0){
		System.out.println("here : "+ seat_Available);
			request.getSession(false).setAttribute("selectedRestaurant", rest);
			rDao.update(rest);
			Booking booking = new Booking();
			booking.setB_date(new Date());
			booking.setBooking_status("BOOKED");
			booking.setRestaurant(rest);
			booking.setCustomer(cust);
			booking.setTable_booked(bookings);
			booking.setBooking_date(bookingDate);
			booking.setLunchDinner(lunchDinner);
			bDao.insert(booking);
			bs.setFor_date(bookingDate);
			bs.setMeal_time(lunchDinner);
			bs.setNo_Of_Seats(bookings);
			bs.setRestaurant(rest);
			bsDao.insert(bs);
			request.setAttribute("Cust", cust);
			request.setAttribute("Rest", rest);
			request.setAttribute("booking", booking);
			request.getRequestDispatcher("ConfirmBooking.jsp").forward(request, response);
			sendMail();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Restaurant rest = (Restaurant)request.getSession(false).getAttribute("selectedRestaurant");
		//System.out.println("88888888888888");
		String target = request.getParameter("target");
		System.out.println(target);
	//if(doBooking==0){
			System.out.println("Here is call");
		if(null != rest){
			Customer cust = (Customer) request.getSession(false).getAttribute("loggedUser");
			if(null == cust){
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else {
				switch(target){
					case "Book Table" : request.getRequestDispatcher("Booking.jsp").forward(request, response);
										break;
					case "Add Feedback" : request.getRequestDispatcher("Feedback.jsp").forward(request, response);
										break;
				}
			}
		}
		//}
		
		
		
	}
	
	public void sendMail(){  
		String host="smtp.gmail.com";  
		  final String user="mymealmailbox@gmail.com";//change accordingly  
		  final String password="dbproject";//change accordingly  
		    
		  String to= cust.getEmail();  
		  System.out.println("mail mail mail");
		   //Get the session object  
		   Properties prop = new Properties();  
		   prop.put("mail.smtp.host",host);  
		   prop.put("mail.smtp.auth", "true");  
		     
		   Properties props = new Properties();  
		    props.setProperty("mail.transport.protocol", "smtp");     
		    props.setProperty("mail.host", "smtp.gmail.com");  
		    props.put("mail.smtp.auth", "true");  
		    props.put("mail.smtp.port", "465");  
		    props.put("mail.debug", "true");  
		    props.put("mail.smtp.socketFactory.port", "465");  
		    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
		    props.put("mail.smtp.socketFactory.fallback", "false");  
		    javax.mail.Session session = javax.mail.Session.getDefaultInstance(props,  
		    new javax.mail.Authenticator() {
		       protected PasswordAuthentication getPasswordAuthentication() {  
		       return new PasswordAuthentication(user,password);  
		   }  
		   });  

		   //session.setDebug(true); 
		    try{
		   Transport transport = session.getTransport();  
		   InternetAddress addressFrom = new InternetAddress(user);  

		   MimeMessage message = new MimeMessage(session);  
		   message.setSender(addressFrom);  
		   String msg = "Dear "+ cust.getFirst_name()+" "+cust.getLast_name()+"\n\n"+"This to inform you that you that your booking for "+bookings+" tables at "+ rest.getName()+" on "+ bookingDate+" for "+ lunchDinner +" has been confirmed.\n\n\n Thanks for being member of mymeal\n\nHave a wonderful time there.\n\n\nRegards\nmymeal Team";
		   message.setSubject("my meal Booking");  
		   message.setContent(msg, "text/plain");  
		   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  

		   transport.connect();  
		   Transport.send(message);  
		   transport.close();
		    } catch(Exception e){
		    	
		    }
	}

}
