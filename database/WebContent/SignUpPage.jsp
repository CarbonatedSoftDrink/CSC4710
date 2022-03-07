<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Twitter Signup</title>
</head>
<body>

<div align="center">
	<h1>Sign Up for Twitter</h1>
	<h2><a href="mainpage">Return Home</a></h2>
	<br><br>
</div>

<div align="center">
	<form action="insertNewUser" method="post">
	
		<c:if test="${user != null}">
        	<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
        </c:if>  
		<label for="username">User ID:</label>
		<input type="text" id="username" name="username"><br><br>
	  	<label for="fname">First name:</label>
	  	<input type="text" id="fname" name="fname"><br><br>
	  	<label for="lname">Last name:</label>
	  	<input type="text" id="lname" name="lname"><br><br>
	  	<label for="age">Age:</label>
	  	<input type="text" id="age" name="age"><br><br>
	  	<label for="password">Password:</label>
	  	<input type="password" id="password" name="password"><br><br>
	  	<label for="confirmPW">Confirm Password:</label>
	  	<input type="password" id="confirmPW" name="confirmPW"><br><br>
	  	<input type="submit" value="Submit">
	</form> 
	<h3>${info}</h3>
</div>

</body>
</html>