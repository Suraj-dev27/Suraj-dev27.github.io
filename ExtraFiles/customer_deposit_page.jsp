<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Deposit Page</title>
</head>
<body>
<h2>Deposit</h2>
<form action="Admin_Validation_Servlet" method="post">
<input type="hidden" name="command" value="customer_deposit">
<table>
<tr>
<td>Enter Amount</td><td><input type="number" name="deposit_amount"></td>
</tr>
</table>
<br><br>
<input type="submit" value="Deposit">
</form>


</body>
</html>