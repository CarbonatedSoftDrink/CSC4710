<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy PPS</title>
</head>
<body>
<div align="center">
        <h1>Buy PPS</h1>
        <h2><a href="homepage">Back to Home</a></h2>
</div>

<div align="center">
	<h3>Your PPS Wallet amount is: ${PPA}</h3>
	<h3>Your U.S. Dollar Wallet amount is: ${USA}</h3>
	<h3>The conversion is $1 to 100 PPS</h3>
</div>

<div align="center">
	<form action="buyPPS" method="post">
		<label for="toBuy">Enter amount of PPS to buy:</label>
		<input type="number" id="toBuy" name="toBuy"><br><br>
		<input type="submit" value="Buy">
	</form>
</div>

<div align="center">
	<h3>${info}</h3>
</div>

</body>
</html>