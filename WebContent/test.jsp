<%@page import="mymealDTO.BookingSummary"%>
<%@page import="mymealDAO.BookingSummaryDAO"%>
<%@page import="mymealDAO.FeedBackDAO"%>
<%@page import="mymealDTO.Feedback"%>
<%@page import="mymealDTO.Booking"%>
<%@page import="mymealDAO.RestaurantDAO"%>
<%@page import="mymealDAO.BookingDAO"%>
<%@page import="mymealDTO.Restaurant"%>
<%@page import="mymealDTO.Customer"%>
<%@page import="mymealDAO.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 	Customer c = new Customer();
 	c.setAddress("40 longwood street");
 	c.setEmail("manisha@zxc.com");
 	c.setFirst_name("Manisha");
 	c.setLast_name("Sharma");
 	c.setPassword("password");
 	c.setPhone_no("9910871956");
 	c.setUser_name("manisha");
 	CustomerDAO cd = new CustomerDAO();
 	cd.insert(c);
 	System.out.println(cd.getAllCustomer().get(0).getUser_name());
	
	%>
	<%
		Restaurant r = new Restaurant();
		r.setName("Chipotle");
		r.setCity("Boston");
		r.setZipcode("12345");
		r.setCost_for_two(500);
		r.setCount_table_total(100);
		r.setRestaurant_img("r9.jpg");
		r.setVegNonveg(true);
		r.setHome_delivery(true);
		r.setBar_available(true);
		RestaurantDAO rd = new RestaurantDAO();
		rd.insert(r);
		Feedback f= new Feedback();
		f.setFeedback("Too bad");
		f.setRestaurant(r);
		FeedBackDAO fd = new FeedBackDAO();
		fd.insert(f);
		Booking b = new Booking();
		b.setRestaurant(r);
		b.setCustomer(c);
		b.setBooking_date("Test");
		b.setLunchDinner("Lunch");
		BookingDAO bd = new BookingDAO();
		bd.insert(b);
		BookingSummaryDAO bsd = new BookingSummaryDAO();
		BookingSummary bs = new BookingSummary();
		bs.setMeal_time("Lunch");
		bs.setNo_Of_Seats(1);
		bs.setRestaurant(r);
		bs.setFor_date("12/18/2013");
		bsd.insert(bs);
		System.out.println(bd.getAllBooking());
		System.out.println(rd.getAllRestaurantsByCity("Boston").get(0).getCity());
		//System.out.println(rd.getAllRestaurants().get(0).getFeedbacks().size());
		//System.out.println(rd.getAllRestaurantsByZipcode("02115"));
	%>

</body>
</html>