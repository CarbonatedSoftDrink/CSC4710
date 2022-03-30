<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Twitter Home Page</title>
</head>
<body>

<div align="center">
        <h1>Welcome to Twitter</h1>
        <h1>You are now signed in as ${username}!</h1>
        <h2><a href="mainpage">Sign Out</a></h2>
</div>

<div align="center">
	<h3>Your PPWallet amount is: ${PPA}</h3>
	<h3>Your U.S. Dollar Wallet amount is: ${USA}</h3>
</div>

<div align="center">
	<h3>
	<a href="buyPage">Buy PPS</a>
	&nbsp;&nbsp;&nbsp;
	<a href="sellPage">Sell PPS</a>
	&nbsp;&nbsp;&nbsp;
	<a href="activities">Activities</a>
	&nbsp;&nbsp;&nbsp;
	<a href="followPage">Follow/Unfollow</a>
	</h3>
</div>

<div align="center">
	<form action="postTweet">
		<label for="makeTweet">Make a new tweet here:</label>
		<input type="text" id="makeTweet" name="makeTweet"><br><br>
		<input type="submit" value="Post">
	</form>
</div>

<h3>${info}</h3>

<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Tweets</h2></caption>
            <tr>
                <th>ID</th>
                <th>Content</th>
                <th>Tweeter</th>
            </tr>
            <c:forEach var="tweet" items="${listTweets}">
                <tr>
                    <td><c:out value="${tweet.id}" /></td>
                    <td><c:out value="${tweet.content}" /></td>
                    <td><c:out value="${tweet.author}" /></td>
                    <td><a href="viewTweet?id=<c:out value='${tweet.id}' />">View</a></td>
                    <!--
                    <td>
                        <a href="edit?id=<c:out value='${people.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${people.id}' />">Delete</a>                     
                    </td>
                    -->
                </tr>
            </c:forEach>
        </table>
</div>   

</body>
</html>