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
<input type="hidden" name=command value="acc_no_to_modify">
<table>
<tr>
<td>Enter Account Number</td><td><input type="number" name="acc_no" pattern="[0-9]{7}" title="Must contain 7 digit Account Number" required ></td>
</tr>
</table>
<input type="submit" value="Submit">
</form>

</body>
</html>