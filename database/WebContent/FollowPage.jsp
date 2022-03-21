<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Follow/Unfollow Users</title>
</head>
<body>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div align="center">
        <h1>Follow/Unfollow Users</h1>
        <h2><a href="homepage">Back to Home</a></h2>
</div>

<div align="center">
	<form method="post">
		<table border="2">
			<tr>
			<td>Twitter Users</td>
			</tr>
			<c:forEach var = "i" begin = "0" end = "${USERS.size()-1}">
				<tr>
					<td>${USERS[i].username}</td>
					<td><a name="follow" href="followUser?id=${USERS[i].id}">Follow</a></td>
				</tr>
			</c:forEach>
		</table>
		</form>
	</div>

<div align="center" style="margin-top: 20px;">
	<form method="post">
		<table border="2">
			<tr>
			<td>Following</td>
			</tr>
			<c:forEach var = "i" begin = "0" end = "${FOLLOWEES.size()-1}">
				<tr>
					<td>${FOLLOWEES[i]}</td>
					<td><a name="unfollow" href="unfollowUser?id=${FOLLOWEES[i]}">Unfollow</a></td>
				</tr>
			</c:forEach>
		</table>
		</form>
	</div>
</body>
</html>