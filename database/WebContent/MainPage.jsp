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
        <h2>
            <a href="login">Login</a>
            &nbsp;&nbsp;&nbsp;
            <a href="signup">Sign Up</a>
        </h2>
</div>

<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2></h2></caption>
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