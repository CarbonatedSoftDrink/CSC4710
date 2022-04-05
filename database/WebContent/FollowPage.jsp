<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Follow/Unfollow Users</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
	<form action="tipPPS" method="post">
		<table border="2">
			<tr>
			<td>Following</td>
			</tr>
			<c:forEach var = "i" begin = "0" end = "${FOLLOWEES.size()-1}">
				<tr>
					<form>
						<td><input name="tipUser" readonly="readonly" value="${FOLLOWEES[i]}"/></td>
						<td><a name="unfollow" href="unfollowUser?username=${FOLLOWEES[i]}">Unfollow</a></td>
						<td><input type="text" name="tipAmt" size="5"/></td>
		                <td><input type="submit" value="Send Tip" /></td>
					</form>
				</tr>
			</c:forEach>
		</table>
		</form>
	</div>
	<div align="center">
		<h3>${info}</h3>
	</div>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>