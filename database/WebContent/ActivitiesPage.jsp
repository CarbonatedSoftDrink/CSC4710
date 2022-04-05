<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activities</title>
</head>
<body>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div align="center">
        <h1>${username}'s Activities</h1>
        <h2><a href="homepage">Back to Home</a></h2>
</div>

<div align="center">
	<h3>Your PP Wallet amount is: ${PPA}</h3>
	<h3>Your U.S. Dollar Wallet amount is: ${USA}</h3>
	<h3>Your PPAddress is: ${PPAD}</h3>
</div>

<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Transaction Activity</h2></caption>
            <tr>
                <th>ID</th>
                <th>Sender Address</th>
                <th>Receiver Address</th>
                <th>PP Amount</th>
                <th>Dollar Amount </th>
                <th>Time</th>
                <th>Type</th>
                <th>Price Per PPS</th>
            </tr>
    
			<tr>
			</tr>
			<c:forEach var = "i" begin = "0" end = "${transactions.size()}">
				<tr>
					<td>${transactions[i].id}</td>
					<td>${transactions[i].fromuser}</td>
					<td>${transactions[i].touser}</td>
					<td>${transactions[i].ppsamt}</td>
					<td>${transactions[i].dollaramt}</td>
					<td>${transactions[i].when}</td>
					<td>${transactions[i].transtype}</td>
					<td><fmt:formatNumber value="${transactions[i].price}" type="currency" currencySymbol="$"/></td>
				</tr>
			</c:forEach>
        </table>
</div>

</body>
</html>