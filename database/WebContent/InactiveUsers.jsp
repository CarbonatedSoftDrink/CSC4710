<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Inactive Users Page</title>
</head>
<body>

<div align="center">
        <h1>Inactive Users Page</h1>
        <h2>
            <a href="rootpage">Back to Home Page</a>
        </h2>
</div>

<div align="center">
	<form action="searchDay">
		<label for="findDay">Enter a date here (YYYY/MM/DD):</label>
		<input type="text" id="findDay" name="findDay"><br><br>
		<input type="submit" value="Search">
	</form>
</div>

<h3 align="center">${info}</h3>

<div class="container-fluid mb-3" align="center">
	<table border="1" cellpadding="5">
	<caption><b>Inactive Users on Given Day</b></caption>
		<tr>
            <th>ID</th>
            <th>UserID</th>
        </tr>
        <c:forEach var="user" items="${listInactiveUsers}">
        <tr>
        	<td><c:out value="${user.id}" /></td>
            <td><c:out value="${user.username}" /></td>
        </tr>
		</c:forEach>
    </table>
</div>


</body>
</html>