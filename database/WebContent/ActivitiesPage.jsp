<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activities</title>
</head>
<body>

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
            <caption><h2>List of Activities</h2></caption>
            <tr>
                <th>ID</th>
                <th>Sender Address</th>
                <th>Receiver Address</th>
                <th>PP Amount</th>
                <th>Dollar Amount </th>
            </tr>
        </table>
</div>

</body>
</html>