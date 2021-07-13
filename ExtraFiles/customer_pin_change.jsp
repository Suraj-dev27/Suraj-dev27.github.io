<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<br>
	<br>
	<form action="Admin_Validation_Servlet" method="post">
		<input type="hidden" name="command" value="customer_change_pin">
		<table>
			<tr>
				<td>Enter Old PIN</td>
				<td><input type="number" name="old_pin" min="1000" max="10000"
					title="Must contain 4 digit pin number" required></td>
			</tr>
			<tr>
				<td>Enter New PIN</td>
				<td><input type="number" name="new_pin" min="1000" max="10000"
					title="Must contain 4 digit pin number" required></td>
			</tr>
		</table>
		<br>
		<br> <input type="submit" value="Change PIN">

	</form>



</body>
</html>