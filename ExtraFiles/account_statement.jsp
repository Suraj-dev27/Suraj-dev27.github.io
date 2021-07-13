<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Admin_Validation_Servlet" method="post">
<input type="hidden" name="command" value="account_statement">
<table>
<tr>
<td>Enter Customer ID </td><td> <input type="number" name="customer_id"  name="customerId" pattern="[0-9]{7}" title="Must contain 7 digit account number" required> </td>
</tr>
<tr>
<td>From Date </td><td> <input type="text" name="from_date" placeholder="yyyy/MM/dd" pattern="[0-9]{4}/[0-9]{2}/[0-9]{2}" required>
</tr>
<tr>
<td>To Date </td><td> <input type="text" name="to_date" placeholder="yyyy/MM/dd" pattern="[0-9]{4}/[0-9]{2}/[0-9]{2}" required>
</tr>
</table>
<br><br>
<input type="submit" value="Generate Account Statement">


</form>
</body>
</html>