<%@page import="mymealDTO.Booking"%>
<%@page import="mymealDTO.Customer"%>
<%@page import="mymealDTO.Restaurant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Booking</title>
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
<img src="${pageContext.request.contextPath}/marquee/img8.jpg" width="" height="100"/>
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
Restaurant rest = (Restaurant)request.getAttribute("Rest");
Customer cust = (Customer)request.getAttribute("Cust");
Booking b = (Booking)request.getAttribute("booking");
//Integer bookingNo = (Integer)request.getAttribute("noOfTables");;
%>

<center><h3>BOOKING CONFIRMATION</h3></center>

<center>
<table border="1">

<tr>
<td>
CUSTOMER NAME
</td>
<td>
<%=cust.getFirst_name()+" "+cust.getLast_name()%>
</td>
</tr>

<tr>
<td>
RESTAURANT NAME
</td>
<td>
<%=rest.getName() %>
</td>
</tr>

<tr>
<td>
SEATS
</td>
<td>
<%=b.getTable_booked() %>
</td>
</tr>

<tr>
<td>
Date of Booking
</td>

<td>
<%=b.getB_date() %>
</td>
</tr>

<tr>
<td>
Booked For:
</td>
<td>
<%=b.getBooking_date() +" for " + b.getLunchDinner() %>
</td>
</tr>



</table>
</center>
<form action="${pageContext.request.contextPath}/NavigationServlet" method="post">
<center><INPUT TYPE="SUBMIT" NAME="home" VALUE="HOME"></center>
</form>

</body>
</html>