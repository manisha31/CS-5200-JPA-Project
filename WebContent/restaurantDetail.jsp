<%@page import="mymealDTO.Feedback"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="mymealDTO.Restaurant"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurant Detail</title>
</head>
<%
	Restaurant r = (Restaurant)session.getAttribute("selectedRestaurant");
List<Feedback> f = (List<Feedback>)session.getAttribute("selectedFeedback");
String bar_img = null;
String veg_NonVeg_img = null;
String home_img = null;
if(r.isBar_available()){
	bar_img = "bar.JPG";
}else {
	bar_img= "noBar.JPG";
}

if(r.isVegNonveg()){
	veg_NonVeg_img = "veg.JPG";
}else {
	veg_NonVeg_img = "noVeg.JPG";
}

if(r.isHome_delivery()){
	home_img = "delivery.JPG";
}else {
	home_img = "noDelivery.JPG";
}
%>
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
<form action="${pageContext.request.contextPath}/BookingServlet" method="post">
<br>
<div id="container" Style = "width:1200px; float: left;">
<center><h3><label for="name_restaurant" ><%=r.getName()%></label></h3><br></center>
<div id="1" style="width:300px; float:left;" >
<center><h3>About Restaurant</h3></center>

<label for="city">City: </label>
<label for="city" ><%=r.getCity()%></label><br>

<label for="zipcode">Zipcode: </label>
<label for="zipcode" ><%=r.getZipcode()%></label><br>


<label for="count_table">Total Number of table in restaurant: </label>
<label for="count_table" ><%=r.getCount_table_total()%></label><br>

<img src="${pageContext.request.contextPath}/options/<%=veg_NonVeg_img %>"/>
<img src="${pageContext.request.contextPath}/options/<%=home_img %>" />
<img src="${pageContext.request.contextPath}/options/<%=bar_img %>" />

<br><br>

<INPUT TYPE="SUBMIT" NAME="target" VALUE="Book Table">
<INPUT TYPE="SUBMIT" NAME="target" VALUE="Add Feedback">

</div>
<div style="width:600px; float:left">
<center><h3>MENU</h3></center>
<img src="${pageContext.request.contextPath}/image/image/<%=r.getRestaurant_img()%>"/>
</div>
<div id="2" style="width:300px; float:right;">

<table border="1">
<center><h3>Feedbacks</h3></center>
<tr>
<td style="width:75px;">
Date
</td>
<td style="width:225px;">
Feedback
</td>

</tr>
<%
	for (int i=0; i< f.size(); i++){
%>
	<tr>
	<td style="width:75px;"><%=f.get(i).getDate_submitted() %>
		<td style="width:225px;"><%=f.get(i).getFeedback() %></td>
			
	</tr>
<%} %>
</table>

</div>
</div>

</form>

</body>
</html>