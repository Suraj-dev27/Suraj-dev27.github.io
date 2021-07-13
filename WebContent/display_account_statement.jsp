<%@page import="java.io.PrintWriter"%>
<%@page import="com.ssd.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.ssd.Transactions"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>
<p style="text-align:center;"><button onclick="window.print()">Print</button></p>

<h2 align="center" style="color:red">KARNATAKA BANK</h2>

<%
List<Object> objects = (List<Object>) request.getAttribute("ACCOUNT_STATEMENT");
List<Transactions> transactions2 = (List<Transactions>) objects.get(0);
Transactions transactions = transactions2.get(0);

Customer customer = (Customer) objects.get(1);

double balance = (Double) objects.get(2);

%>

<table style="font-size:20px;">
<tr>
<td>Customer ID:</td><td><%= customer.getCustomerId() %></td>
</tr>
<tr>
<td>Customer Name:</td><td><%= customer.getFull_name() %></td>
</tr>
<tr>
<td>Mobile Number:</td><td><%= customer.getMobile_number() %></td>
</tr>
<tr>
<td>Card Number:</td><td><%= transactions.getCard_no() %></td>
</tr>
<tr>
<td>Account Type:</td><td><%= customer.getAccount_type() %></td>
</tr>
</table>

<hr>

<table border="1"  style="margin-left: auto; margin-right: auto;">
<tr>
<th>Transaction Date</th><th>Transaction Amount</th>
</tr>

<%

for(Transactions transaction : transactions2){
	out.println("<tr><td align=\"center\">"+transaction.getTransaction_date()+"</td><td align=\"center\">"+transaction.getTransaction_amount()+"</td></tr>");
}
%>
<tr>
<td align="center">Balance</td><td align="center"><%= balance %></td>
</tr>
</table>




</body>
</html>