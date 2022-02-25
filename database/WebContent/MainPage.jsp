<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
            <caption><h2>List of Tweets // Under Construction!</h2></caption>
            <tr>
                <th>ID</th>
                <th>Tweeter</th>
                <th>Content</th>
            </tr>
            <!-- 
            <c:forEach var="people" items="${listPeople}">
                <tr>
                    <td><c:out value="${people.id}" /></td>
                    <td><c:out value="${people.name}" /></td>
                    <td><c:out value="${people.address}" /></td>
                    <td><c:out value="${people.status}" /></td>
                    <td>
                        <a href="edit?id=<c:out value='${people.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${people.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
            -->
        </table>
</div>   

</body>
</html>