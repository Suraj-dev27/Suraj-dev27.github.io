<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Customer Account</title>
</head>
<body>

	<form action="Admin_Validation_Servlet" method="post">

		<input type="hidden" name="command" value="add_customer">

		<table>
			<tr>
				<td>Full Name</td>
				<td><input type="text" name="full_name" pattern ="^[a-zA-Z]+ [a-zA-Z]+ [a-zA-Z]+$" title="Please Enter Full Name" required></td>
			</tr>

			<tr>
				<td>Fathers Name</td>
				<td><input type="text" name="fathers_name" pattern ="^[a-zA-Z]+ [a-zA-Z]+ [a-zA-Z]+$" title="Please Enter Full Name" required></td>
			</tr>
			
			<tr>
				<td>Email ID</td>
				<td><input type="text" name="email_id" pattern ="[a-zA-Z0-9_-.+]+@[a-zA-Z0-9-.]+([.][a-zA-z0-9]){2}" placeholder="abc@gmail.com" required></td>
			</tr>

			<tr>
				<td>Date Of Birth</td>
				<td><input type="text" name="dob" placeholder="yyyy-MM-dd" pattern ="[0-9]{4}-[0-9]{2}-[0-9]{2}" required>
				</td>
			</tr>

			<tr>
				<td>Gender</td>
				<td><input type="text" name="gender" pattern="[a-zA-Z]+" required></td>
			</tr>

			<tr>
				<td>Permanent Address</td>
				<td><input type="text" name="permanent_address" required></td>
			</tr>

			<tr>
				<td>Present Address</td>
				<td><input type="text" name="present_address" required></td>
			</tr>

			<tr>
				<td>PAN Number</td>
				<td><input type="text" name="pan_number" pattern="[a-zA-Z0-9]{0,10}" required></td>
			</tr>

			<tr>
				<td>Mobile Number</td>
				<td><input type="tel" name="mobile_number" required></td>
			</tr>

			<tr>
				<td>Landline Number</td>
				<td><input type="tel" name="landline" required></td>
			</tr>

			<tr>
				<td>Account Type</td>
				<td><input type="text" name="account_type" pattern = "([a-zA-z]+\s*[a-zA-z]*){0,10}" required ></td>
			</tr>

			<tr>
				<td>CheckBook:</td>
				<td><input type="radio" name="check_book" value="yes" checked>Yes
					<input type="radio" name="check_book" value="no">No</td>
			</tr>

		</table>
		<br>
		<br> <input type="submit" value="Add Customer">
	</form>
	
	
</body>
</html>