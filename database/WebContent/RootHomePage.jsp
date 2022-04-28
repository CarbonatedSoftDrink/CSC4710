<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Root Twitter Home Page</title>
</head>
<body>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div align="center">
        <h1>Welcome to Twitter</h1>
        <h1>You are now signed in as Root User!</h1>
        <h2>
            <a href=mainpage>Sign Out</a>
        </h2>
        <h2><a href=rootActivate>Initialize Database Tables</a></h2>
</div>

<div class="container-fluid mb-3" align="center">
	<table border="1" cellpadding="5">
	<caption><b>Big Influencers</b></caption>
		<tr>
            <th>UserID</th>
        </tr>
        <c:forEach var="user" items="${listBigInfluencers}">
        <tr>
        	<td><c:out value="${user}" /></td>
        </tr>
		</c:forEach>
    </table>
</div>
<br>
<div class="container-fluid mb-3" align="center">
	<table border="1" cellpadding="5">
	<caption><b>Big Whales</b></caption>
		<tr>
            <th>UserID</th>
        </tr>
        <c:forEach var="user" items="${listBigWhales}">
        <tr>
        	<td><c:out value="${user}" /></td>
        </tr>
		</c:forEach>
    </table>
</div>
<br>
<div class="container-fluid mb-3" align="center">
	<table border="1" cellpadding="5">
	<caption><b>Frequent Buyers</b></caption>
		<tr>
            <th>UserID</th>
        </tr>
        <c:forEach var="user" items="${listFrequentBuyers}">
        <tr>
        	<td><c:out value="${user}" /></td>
        </tr>
		</c:forEach>
    </table>
</div>
<br>
<div class="container-fluid mb-3" align="center">
	<table border="1" cellpadding="5">
	<caption><b>Good Followers</b></caption>
		<tr>
            <th>UserID</th>
        </tr>
        <c:forEach var="user" items="${listGoodFollowers}">
        <tr>
        	<td><c:out value="${user}" /></td>
        </tr>
		</c:forEach>
    </table>
</div>
<br>
<div align="center">
	<form name="commonFollowerForm" method="post" action="commonFollowerServlet">
	 	<select name="user1">
	        <c:forEach items="${listUsers}" var="user">
	            <option value="${user}">${user}</option>
	        </c:forEach>
	    </select>
	    <select name="user2">
	        <c:forEach items="${listUsers}" var="user">
	            <option value="${user}">${user}</option>
	        </c:forEach>
	    </select>
	    <br/><br/>
	    <input type="submit" value="Submit" />
	</form>
	<tr>
    	<td><c:out value="${commonFollowers}"/></td>
    </tr>
	</div>
<br>
<div class="container-fluid mb-3" align="center">
	<table border="1" cellpadding="5">
	<caption><b>Diamond Hands</b></caption>
		<tr>
            <th>ID</th>
            <th>UserID</th>
        </tr>
        <c:forEach var="user" items="${listDiamondHands}">
        <tr>
        	<td><c:out value="${user.id}" /></td>
            <td><c:out value="${user.username}" /></td>
        </tr>
		</c:forEach>
    </table>
</div>
<br>
<div class="container-fluid mb-3" align="center">
	<table border="1" cellpadding="5">
	<caption><b>Paper Hands</b></caption>
		<tr>
            <th>ID</th>
            <th>UserID</th>
        </tr>
        <c:forEach var="user" items="${listPaperHands}">
        <tr>
        	<td><c:out value="${user.id}" /></td>
            <td><c:out value="${user.username}" /></td>
        </tr>
		</c:forEach>
    </table>
</div>
<br>
<div class="container-fluid mb-3" align="center">
	<table border="1" cellpadding="5">
	<caption><b>Good Influencers</b></caption>
		<tr>
            <th>UserID</th>
        </tr>
        <c:forEach var="user" items="${listGoodInfluencers}">
        <tr>
            <td><c:out value="${user.username}" /></td>
        </tr>
		</c:forEach>
    </table>
</div>
<br>
<div align="center">
<a href=inactiveusers>Inactive Users</a>
</div>
<br>
<div align="center">
<a href=userStats>User Statistics</a>
</div>
<br>
</body>
</html>