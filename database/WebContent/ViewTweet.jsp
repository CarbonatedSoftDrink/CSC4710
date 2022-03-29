<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>View Tweet</title>
</head>
<body>
<div align="center">
        <h2><a href="homepage">Back to Home</a></h2>
</div>

<div align="center">
	<h3>Viewing tweet</h3>
	<h3>This tweet has ${likes} likes!</h3>
	<h2><a href="addLike">Like Tweet</a></h2>
</div>

<div align="center">
        <table border="1" cellpadding="5">
            <!--<caption><h2>Tweet // Under Construction!</h2></caption>-->
            <tr>
                <th>ID</th>
                <th>Content</th>
                <th>Tweeter</th>
            </tr>
            <tr>
            	<th>${tweet.id}</th>
                <th>${tweet.content}</th>
                <th>${tweet.author}</th>
            </tr>
            <c:forEach var="tweet" items="${listComments}">
                <tr>
                    <td><c:out value="${tweet.id}" /></td>
                    <td><c:out value="${tweet.content}" /></td>
                    <td><c:out value="${tweet.author}" /></td>
                    <!-- <td><a href="viewTweet?id=<c:out value='${tweet.id}' />">View</a></td> -->
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
<br>
<div align="center">
	<form action="addComment" method="post">
		<label for="makeComment">Make a comment to this tweet here:</label>
		<input type="text" id="makeComment" name="makeComment"><br><br>
		<input type="submit" value="Post">
	</form>
</div>

<div align="center">
	<h3>${info}</h3>
</div>

</body>
</html>