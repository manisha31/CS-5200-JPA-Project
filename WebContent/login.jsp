<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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
	String error_msg = (String)session.getAttribute("error_msg");
%>
<center>
<form action="${pageContext.request.contextPath}/LoginServlet" method="post">

<center><label for="error" >${error_msg}</label></center><br><br>

<div style="width: 300;">
<label for="username" >Enter UserName :</label></label><input type="text" id="srt" name="userName" placeholder="User Name" required="true">
<br>
<label for="password" >Enter Password :</label><input type="Password" id="srt" name="password" placeholder="Password" required="true">
<br>
<INPUT TYPE="SUBMIT" NAME="SignIn" VALUE="Sign In" style="width: 200px;">
</div>

  <INPUT TYPE="SUBMIT" NAME="SignUp" VALUE="Sign Up" onclick="doSubmit();" style="width: 200px;">
<input type="hidden" name="target" value="<%=request.getParameter("target") %>" >
</form>
</center>
</body>
</html>