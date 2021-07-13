
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="header.html" />
<a style="margin-left:20px; margin-top:20px;" href="admin_gui_page.jsp">Back</a>
	<hr>
	<!-- --------------------------------------------------------------------------------------------------- -->


	<table border="1">

		<tr>
			<th>CustomerID</th>
			<th>Account No</th>
			<th>Card No</th>
			<th>Full Name</th>
			<th>Fathers Name</th>
			<th>Email ID</th>
			<th>DOB</th>
			<th>Gender</th>
			<th>Permanent Addr</th>
			<th>Present Addr</th>
			<th>PAN Number</th>
			<th>Mobile Number</th>
			<th>Landline</th>
			<th>Account Type</th>
			<th>Openning Balance</th>
			<th>CheckBook</th>
		</tr>

		<c:forEach var="tempCustomer" items="${CUSTOMER_LIST}">			
			
			<tr>
			<td>${tempCustomer.customerId }</td>
			<td>${tempCustomer.acc_no }</td>
			<td>${tempCustomer.card_no }</td>
			<td>${tempCustomer.full_name }</td>
			<td>${tempCustomer.fathers_name }</td>
			<td>${tempCustomer.email_id }</td>
			<td>${tempCustomer.dob }</td>
			<td>${tempCustomer.gender }</td>
			<td>${tempCustomer.permanent_address }</td>
			<td>${tempCustomer.present_address }</td>
			<td>${tempCustomer.pan_number }</td>
			<td>${tempCustomer.mobile_number }</td>
			<td>${tempCustomer.landline }</td>
			<td>${tempCustomer.account_type }</td>
			<td>${tempCustomer.openning_balance }</td>
			<td>${tempCustomer.check_book }</td>
			</tr>
			
			
		</c:forEach>



	</table>


</body>
</html>