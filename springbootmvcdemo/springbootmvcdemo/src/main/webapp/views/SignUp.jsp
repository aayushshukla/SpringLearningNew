<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
</head>
<body>
         <form action="sigupdetails" method="post">
             <%--feilds name should be same as class variable names --%>
              TrainerName : <input type="text" name="trainerName"> <br>
              TrainerEmai : <input type="email" name="trainerEmail"><br>
              TPassword   : <input type="password" name="trainerPassword"> <br>
              TrainerExp : <input type="number" name="exp">
              <input type="submit" value="SignUp"> 
         

         </form>

</body>
</html>