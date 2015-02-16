<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking the tables in restaurant</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
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
<h3>${message}</h3>
<form action="${pageContext.request.contextPath}/BookingServlet" method="get">
<div><center>
<label for="booking">Enter number of tables to be booked:</label>
<input type="text" id="bk" name="bookings" placeholder="Number of Seats"><br>
<input type="radio" value="Lunch" name="LunchDinner"><label for="Lunch">Lunch</label><input type="radio" Value="Dinner" name="LunchDinner"><label for="Dinner">Dinner</label><br>
<label for="bookingDate">Enter date for booking:</label><input type="text" name="bookingDate" id="datepicker">
<br>
<INPUT TYPE="SUBMIT" NAME="Book" VALUE="Book">
</center></div>
<div style="float: right;">

</div>
</form >
<form action="${pageContext.request.contextPath}/AllBookingsServlet" method="post">
<INPUT TYPE="SUBMIT" NAME="seeBooking" VALUE="My Bookings"></a>
</form>
</body>
</html>