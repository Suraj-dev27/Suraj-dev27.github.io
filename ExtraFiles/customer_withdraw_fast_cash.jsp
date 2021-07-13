<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw Fast Cash</title>
</head>
<body>
	<h2 align="center">Withdraw (Get Cash)</h2>

	<h3>Select Amount to Withdraw</h3>
	<form action="Admin_Validation_Servlet" method="post">
		<input type="hidden" name="command" value="fast_cash">

		<table>
			<tr>
				<td><input type="submit" value="500" name="500"></td>
				<td><input type="submit" value="1000" name="1000"></td>
			</tr>
			<tr>
				<td><input type="submit" value="2000" name="2000"></td>
				<td><input type="submit" value="5000" name="5000"></td>
			</tr>
		</table>


	</form>


</body>
</html>