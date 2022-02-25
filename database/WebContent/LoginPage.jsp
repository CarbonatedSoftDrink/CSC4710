<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login to Twitter</title>
</head>
<body>

<div align="center">
        <h1>Twitter Login</h1>
        <a href="mainpage">Return Home</a><br><br>
</div>

<div align="center">
	<form action="/action_page.php">
  		<label for="username">UserID:</label>
  		<input type="text" id="username" name="username"><br><br>
  		<label for="password">Password:</label>
  		<input type="password" id="passwor" name="password"><br><br>
  		<input type="submit" value="Submit">
	</form> 
</div>

</body>
</html>