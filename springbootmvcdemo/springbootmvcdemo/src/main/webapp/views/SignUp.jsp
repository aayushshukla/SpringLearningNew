<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
</head>
<body>
   <div>
   <%-- @directive tags better for static pages , includes resource at translation time --%>
       <%@include file="header.jsp" %>
   
   </div>

    <div>
         <form action="sigupdetail" method="post">
             <%--feilds name should be same as class variable names --%>
              TrainerName : <input type="text" name="trainerName" required="required">  <br>
              TrainerEmai : <input type="email" name="trainerEmail"><br>
              TPassword   : <input type="password" name="trainerPassword"> <br>
              TrainerExp : <input type="number" name="exp">
              <input type="submit" value="SignUp"> 
         

         </form>
         <%-- JSP Scripting element 3 tags
            1. scriplet tag
            2. declaration tag : declaring variable and methods
            3. expression tag  for output
         
          --%>
     </div>
      <div>
        <h3> 
	        <% 
	          String msg= (String) request.getAttribute("message");
	          if(msg!=null)
	          {  %>
	        	 
	        	  <%=msg%>
	        	  <jsp:forward page="login.jsp"></jsp:forward>
	        <%   
	             }  
	        
	        %> 
        </h3>
        <%-- el : expression language  ${variablename / expression } --%>
      </div> 
        <div>
        <%-- actiontags  jsp:action  better for dynamic pages , includes resource at request time --%>
            <jsp:include page="footer.jsp"/>
        
        </div>
</body>
</html>