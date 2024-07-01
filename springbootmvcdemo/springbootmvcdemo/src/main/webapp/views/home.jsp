<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<div>
   <%-- @directive tags better for static pages , includes resource at translation time --%>
       <%@include file="header.jsp" %>
   
   </div>

      <h3>Welcome To Home Page</h3>
      <a href="signup">SignUp</a>
       <a href="login">Login</a>
</body>
</html>