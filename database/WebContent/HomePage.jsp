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
	<a href="buyPage">Sell PPS</a>
	&nbsp;&nbsp;&nbsp;
	<a href="activities">Activities</a>
	</h3>
</div>

<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Tweets // Under Construction!</h2></caption>
            <tr>
                <th>ID</th>
                <th>Tweeter</th>
                <th>Content</th>
            </tr>
        </table>
</div>

</body>
</html>