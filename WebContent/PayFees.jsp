<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/fees.css">
</head>
<body>
<div>
	<form method="post" action="PayFeesServlet">
	<h2 align="center">FEES DETAILS</h2>
		<h3>Standard</h3>
		<select name="standard">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
		</select>             
		<h3>Student ID</h3>
		<input type="text" placeholder="Student Id" name="studentid" />
		<h3>Date</h3>
		<input type="date" name="date" /><br><br>
		<h3>Type of Payment</h3>
		<select name="typeofpayment">
			<option value="Cash">Cash</option>
			<option value="Cheque">Cheque</option>
		</select>
		
		<%-- <input type="text" placeholder="Type of Payement" name="typeofpayement"/>--%>
		<h3>Amount</h3>
		<input type="text" placeholder="Amount" name="amount"/>
		<input type="submit" value="Add Payement" />
		</div>
	</form>
</body>
</html>