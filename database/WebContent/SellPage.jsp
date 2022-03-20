<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sell PPS</title>
</head>
<body>
<div align="center">
        <h1>Sell PPS</h1>
        <h2><a href="homepage">Back to Home</a></h2>
</div>

<div align="center">
	<h3>Your PP Wallet amount is: ${PPA}</h3>
	<h3>Your U.S. Dollar Wallet amount is: ${USA}</h3>
	<h3>The conversion is $1 to 100 PPS</h3>
</div>

<div align="center">
	<form action="sellPPS" method="post">
		<label for="toSell">Enter amount of PPS to sell:</label>
		<input type="number" id="toSell" name="toSell"><br><br>
		<input type="submit" value="Sell">
	</form>
</div>

<div align="center">
	<h3>${info}</h3>
</div>

</body>
</html>