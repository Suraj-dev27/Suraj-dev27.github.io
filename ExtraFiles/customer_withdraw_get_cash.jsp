<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">Withdraw (Get Cash)</h2>

	<form action="Admin_Validation_Servlet" method="post">
		<input type="hidden" name="command" value="get_cash">

		<table>
			<tr>
				<td>Enter Amount to Withdraw</td>
				<td><input type="number" name="get_cash"></td>
			</tr>
		</table>
		<br>
		<br> <input type="submit" value="Get Cash">

	</form>

</body>
</html>