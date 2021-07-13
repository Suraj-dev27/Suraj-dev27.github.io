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

		<input type="hidden" name="command" value="modify_customer">
		
		<!-- another hidden field to pass acc_no to servlet to store data -->
		<input type="hidden" name="account_no" value="${CUSTOMER_MODIFY_INFO.acc_no }">
		
		<!--  <input type="hidden" name="customerId" value="${THE_CUSTOMER.customerId }">   -->

		<table>
		
			<tr>
				<td>Full Name</td>
				<td><input type="text" name="full_name" value="${CUSTOMER_MODIFY_INFO.full_name }" required></td>
			</tr>

			<tr>
				<td>Fathers Name</td>
				<td><input type="text" name="fathers_name" value="${CUSTOMER_MODIFY_INFO.fathers_name }" required></td>
			</tr>

			<tr>
				<td>Date Of Birth</td>
				<td><input type="text" name="dob" value="${CUSTOMER_MODIFY_INFO.dob }" required>
				</td>
			</tr>

			<tr>
				<td>Permanent Address</td>
				<td><input type="text" name="permanent_address" value="${CUSTOMER_MODIFY_INFO.permanent_address }" required></td>
			</tr>

			<tr>
				<td>Present Address</td>
				<td><input type="text" name="present_address" value="${CUSTOMER_MODIFY_INFO.present_address }" required></td>
			</tr>

			<tr>
				<td>PAN Number</td>
				<td><input type="text" name="pan_number" value="${CUSTOMER_MODIFY_INFO.pan_number }" required></td>
			</tr>

			<tr>
				<td>Mobile Number</td>
				<td><input type="tel" name="mobile_number" value="${CUSTOMER_MODIFY_INFO.mobile_number }" required></td>
			</tr>

			<tr>
				<td>Landline Number</td>
				<td><input type="tel" name="landline" value="${CUSTOMER_MODIFY_INFO.landline }" required></td>
			</tr>

			<tr>
				<td>Account Type</td>
				<td><input type="text" name="account_type" value="${CUSTOMER_MODIFY_INFO.account_type }" required></td>
			</tr>

			<tr>
				<td>CheckBook:</td>
				<td><input type="text" name="check_book" value="${CUSTOMER_MODIFY_INFO.check_book }" required></td>
			</tr>

		</table>
		<br>
		<br> <input type="submit" value="Modify Customer">
	</form>
</body>
</html>