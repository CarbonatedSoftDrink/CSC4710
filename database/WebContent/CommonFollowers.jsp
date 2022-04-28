<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<table border="1" cellpadding="5">
	<caption><b>Common Followers</b></caption>
        <tr>
        	<td><c:out value="${commonFollowers}"/></td>
        </tr>
    </table>
</body>
</html>