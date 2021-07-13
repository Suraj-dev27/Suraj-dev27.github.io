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
<input type="hidden" name="command" value="delete_customer">
Enter CustomerID to delete:<input type="number" name="customerId"  pattern="[0-9]{7}" title="Must contain 7 digit account number" required>
<input type="submit" value="Delete"
onclick = "if (!(confirm('Are you sure you want to delete this customer?'))) return false">
</form>


</body>
</html>