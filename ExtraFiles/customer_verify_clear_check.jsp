<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Verify and Clear Check</title>
</head>
<body>



<br><br>

<form action="Admin_Validation_Servlet" method="post">
<input type="hidden" name="command" value="check_clear">
<table>
<tr>
<td>Account Number</td><td><input type="number" name="acc_no" pattern="[0-9]{7}" title="Must contain 7 digit account number" required></td>
</tr>
<tr>
<td>Check Number</td><td><input type="number" name="check_number" required></td>
</tr>
<tr>
<td>Amount</td><td><input type="number" name="check_amount" required></td>
</tr>

</table>
<input type="submit" value="Clear Check">
</form>


</body>
</html>