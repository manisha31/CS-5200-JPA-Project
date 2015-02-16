<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
<%
	String error_user = (String)session.getAttribute("error_user");
%>
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
<center>
<form action="${pageContext.request.contextPath}/CustomerServlet" method="post">
<center><label for="error" >${error_user}</label></center><br><br>
<br>
<label for="enter">Enter the following details: </label><br><br>
<label for="user_name">User Name</label>
<input type="text" id="u1" name="user_name" placeholder="user_name" required="true"><br>
<label for="password">Password</label>
<input type="text" id="u2" name="password" placeholder="password" required="true"><br>
<label for="first_name">First Name</label>
<input type="text" id="u3" name="first_name" placeholder="first_name" required="true"><br>
<label for="last_name">Last Name</label>
<input type="text" id="u4" name="last_name" placeholder="last_name" required="true"><br>
<label for="email">Email</label>
<input type="text" id="u5" name="email" placeholder="email" required="true"><br>
<label for="address">Address</label>
<input type="text" id="u6" name="address" placeholder="address" required="true"><br>
<label for="phone_no">Phone Number</label>
<input type="text" id="u7" name="phone_no" placeholder="phone_no" required="true"><br>


<INPUT TYPE="SUBMIT" NAME="SignUpSubmit" VALUE="Sign up">
<input type="hidden" name="target" value="<%=request.getParameter("target") %>">
</form>
</center>
</body>
</html>