<%@page import="mymealDTO.Booking"%>
<%@page import="java.util.List"%>
<%@page import="mymealDTO.Customer"%>
<%@page import="mymealDTO.Restaurant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Bookings</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/NavigationServlet" method="post">
<div>
<img src="${pageContext.request.contextPath}/logo/mymeal.jpg"style="float: left;"/><center><h1>mymeal Restaurant Search</h1></center><br><br><br><br>
<marquee><img src="${pageContext.request.contextPath}/marquee/img1.jpg" width="" height="100"/>
<img src="${pageContext.request.contextPath}/marquee/img2.jpg" width="" height="100"/>
<img src="${pageContext.request.contextPath}/marquee/img3.jpg" width="" height="100"/>
<img src="${pageContext.request.contextPath}/marquee/img4.jpg" width="" height="100"/>
<img src="${pageContext.request.contextPath}/marquee/img5.jpg" width="" height="100"/>
<img src="${pageContext.request.contextPath}/marquee/img6.jpg" width="" height="100"/>
<img src="${pageContext.request.contextPath}/marquee/img7.jpg" width="" height="100"/>
S<img src="${pageContext.request.contextPath}/marquee/img8.jpg" width="" height="100"/>
<img src="${pageContext.request.contextPath}/marquee/img9.jpg" width="" height="100"/>
<img src="${pageContext.request.contextPath}/marquee/img10.jpg" width="" height="100"/></marquee>
<div style="float: right;">
	 <INPUT TYPE="SUBMIT" NAME="contactUs" VALUE="Contact US">
	  <INPUT TYPE="SUBMIT" NAME="home" VALUE="Home">
</div>
<hr noshade size=7>
</div>
<br>
<br>
</form>
<%
List<Booking> filterBooking = (List<Booking>)request.getAttribute("BookingList");
%>

<form action="${pageContext.request.contextPath}/AllBookingsServlet" method="post">
<center><h3><%=filterBooking.get(0).getCustomer().getFirst_name()%>'s Bookings</h3></center>
<center>
<table border="1">
<tr>
<td>
DONE ON
</td>

<td>
DONE FOR
</td>

<td>
SEATS
</td>

<td>
RESTAURANT
</td>



</tr>

<%for(int i=0; i<filterBooking.size();i++){
	%>

<tr>

<td>
<%= filterBooking.get(i).getB_date() %>
</td>

<td>
<%=filterBooking.get(i).getBooking_date() %> for <%=filterBooking.get(i).getLunchDinner()%>
</td>

<td>
<%=filterBooking.get(i).getTable_booked() %>
</td>

<td>
<%=filterBooking.get(i).getRestaurant().getName() %>
</td>



</tr>
	
	
	
<%} %>

</table>
</center>
</form>


</body>
</html>