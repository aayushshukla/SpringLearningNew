<%@page import="com.infosys.springbootmvcdemo.Model.Trainer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trainer Details</title>
</head>
<body>
<div>
    <%@include file="header.jsp" %>
</div>
  <table border="1">
  <tr>  
        <th> Trainer Name</th>
         <th>Trainer Email </th>
   </tr>
 
   <c:forEach var="trainer" items="${trainerList}">
   <tr>
      <td> <c:out value="${trainer.getTrainerName()}"></c:out> </td>
       <td> <c:out value="${trainer.getTrainerEmail()}"></c:out> </td>
       <td> <a href="">Update </a>
       <td> <a href="deleteTrainer?trainerid=${trainer.getTrainerId()}">Delete</a>
       
   </tr>
   </c:forEach>
  </table>
         
         
        
</body>
</html>