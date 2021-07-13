<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Branch</title>
</head>
<body>

<br><br>
<form action="Admin_Validation_Servlet" method="post">
<input type="hidden" name="command" value="add_branch">
<table>
<tr>
<td>Branch Name:</td><td><input type="text" name="branch_name" required></td>
</tr>
<tr>
<td>Branch State:</td><td><input type="text" name="branch_state" required></td>
</tr>
</table>
<br><br>
<input type="submit" value="Add Branch">
</form>


</body>
</html>