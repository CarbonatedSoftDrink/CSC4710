<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Stats Page</title>
</head>
<body>

<div align="center">
        <h1>User Stats Page</h1>
        <h2>
            <a href="rootpage">Back to Home Page</a>
        </h2>
</div>

<div align="center">
	<form action="searchUser">
		<label for="findUser">Enter a username here:</label>
		<input type="text" id="findUser" name="findUser"><br><br>
		<input type="submit" value="Search">
	</form>
</div>

<h3 align="center">${info}</h3>

<div class="container-fluid mb-3" align="center">
	<table border="1" cellpadding="5">
	<caption><b>User Statistics</b></caption>
		<tr>
			<th>Username</th>
            <th>Buys</th>
            <th>Sells</th>
            <th>Tips</th>
            <th>Followers</th>
            <th>Followees</th>
        </tr>
        <tr>
        	<td>${username}</td>
        	<td>${buys}</td>
        	<td>${sells}</td>
        	<td>${tips}</td>
        	<td>${followers}</td>
        	<td>${followees}</td>
        </tr>
    </table>
</div>


</body>
</html>