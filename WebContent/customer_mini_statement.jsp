<%@page import="com.ssd.Transactions"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mini Statement</title>
</head>
<body>

<p style="text-align:center;"><button onclick="window.print()">Print</button></p>
<h2 align="center">KARNATAKA BANK</h2>
<h3 align="center">Mini Statement</h3>
<hr>


<%
List<Transactions> transactions = (List<Transactions>) request.getAttribute("MINI_STATEMENT");
Transactions transactions2 = transactions.get(0);
%>

<p style="text-align:center;">Your Card No. is : <%= transactions2.getCard_no() %></p>
<br><br>
<table border="1" style="margin-left:auto; margin-right:auto;">
<tr>
<th  align="center">Transaction Date</th><th align="center">Transaction Amount</th>
</tr>

<!-- here for loop will be used to print data -->
<c:forEach var="transaction" items="${MINI_STATEMENT }">

<tr>
<td align="center">${transaction.transaction_date }</td><td align="center">${transaction.transaction_amount }</td>
</tr>

</c:forEach>

</table>

</body>
</html>