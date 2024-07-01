<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Info</title>
</head>
<body>
    <form action="updateInfo" method="post">
      <input type="text" name="trainerId" hidden value="${tid}"> <br>
       TrainerEmail : <input type="email" name="trainerEmail" ><br>
       TrainerPassword : <input type="password" name="trainerPassword"><br>
       TrainerExp : <input type="number" name="exp"><br>
       <input type="submit" value="Update">
    </form>
 
</body>
</html>