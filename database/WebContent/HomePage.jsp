<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Twitter Home Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="sticky-top container-fluid border border-primary mt-0 mb-1 ml-0 mr-0 text-center pt-2 bg-primary w-100">
	<h3>
	<a class="text-white" href="buyPage">Buy PPS</a>
	&nbsp;&nbsp;&nbsp;
	<a class="text-white" href="sellPage">Sell PPS</a>
	&nbsp;&nbsp;&nbsp;
	<a class="text-white" href="activities">Activities</a>
	&nbsp;&nbsp;&nbsp;
	<a class="text-white" href="followPage">Follow/Unfollow</a>
	</h3>
</div>
<div class="container-fluid">
        <h3>You are now signed in as ${username} <a class="float-right h4" href="mainpage">Sign Out</a></h3>
</div>

<div class="container-fluid">
	<h5 class="text-left">PPS Balance: ${PPA}</h5>
	<h5 class="text-left">USD Balance: ${USA}</h5>
</div>

<div align="center">
	<form action="postTweet" class="row w-100">
		<input style="width: 85%; margin-left: 1%;" class="form-group col-xs-6 mb-0 mt-3" type="text" id="makeTweet" name="makeTweet"><br><br>
		<input class="form-group col-xs-6 mb-0 mt-3 w-5" type="submit" value="Tweet">
	</form>
</div>

<h3>${info}</h3>

<div class="container-fluid mb-3">
        <table border="1" cellpadding="5">
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