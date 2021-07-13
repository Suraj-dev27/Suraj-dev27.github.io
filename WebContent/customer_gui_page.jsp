<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>KARNATAKA BANK</title>
<link rel="stylesheet" href="customer_gui_page_css.css" type="text/css">


<style>
.ontop {
	z-index: 999;
	width: 100%;
	height: 100%;
	top: 0;
	left: 0;
	display: none;
	position: absolute;
	background-color: #cccccc;
	color: #aaaaaa;
	opacity: 0.95;
	filter: alpha(opacity = 50);
}

#popup {
	width: 400px;
	height: 250px;
	position: absolute;
	color: #000000;
	background-color: cyan;
    box-shadow: 10px 10px 5px grey;
    border-radius: 25px;
	/* To align popup window at the center of screen*/
	top: 50%;
	left: 50%;
	margin-top: -100px;
	margin-left: -200px;
    
}
</style>

</head>
<body>

	<jsp:include page="header.html" />

	<!-- --------------------------------------------------------------------------------------------------- -->

	<script>
		function pop(div) {
			document.getElementById(div).style.display = 'block';
		}
		function hide(div) {
			document.getElementById(div).style.display = 'none';
		}
		//--------------------------------------------------------------------------------

		/*function pinChangeForm() {
			var x = document.getElementById("pinchange");
			if (x.style.display === "none") {
				x.style.display = "block";
			} else {
				x.style.display = "none";
			}
		}
		//--------------------------------------------------------------------------------

		function getCashForm() {
			var x = document.getElementById("getcash");
			if (x.style.display === "none") {
				x.style.display = "block";
			} else {
				x.style.display = "none";
			}
		}
		//--------------------------------------------------------------------------------

		function fastCashForm() {
			var x = document.getElementById("fastcash");
			if (x.style.display === "none") {
				x.style.display = "block";
			} else {
				x.style.display = "none";
			}
		}
		//--------------------------------------------------------------------------------

		function depositeForm() {
			var x = document.getElementById("deposit");
			if (x.style.display === "none") {
				x.style.display = "block";
			} else {
				x.style.display = "none";
			}
		}*/
		//--------------------------------------------------------------------------------

		function viewBalanceForm() {
			var x = document.getElementById("viewbalance");
			if (x.style.display === "none") {
				x.style.display = "block";
			} else {
				x.style.display = "none";
			}
		}
		//--------------------------------------------------------------------------------

		function miniStmtForm() {
			var x = document.getElementById("ministmt");
			if (x.style.display === "none") {
				x.style.display = "block";
			} else {
				x.style.display = "none";
			}

		}
	</script>

	<!-- ------------------------------------------------------------------------- -->
	<!-- ------------------------------------------------------------------------- -->

	<div class="button-container" style="margin-top: 63px">
		<form name="pin_change">
			<div>
				<input class="input" type="button" value="PIN Change"
					onclick="pop('pinchange')">
			</div>
		</form>

		<form name="get_cash">
			<div>
				<input class="input" type="button" value="Withdrawal (Get Cash)"
					onclick="pop('getcash')">
			</div>
		</form>
	</div>

	<!-- ------------------------------------------------------------------------- -->

	<div  id="pinchange" class="ontop">
	<div id="popup">
	
	
	<div class="center">
	
		<form action="Admin_Validation_Servlet" method="post" style="margin-top:20px;">
			<input type="hidden" name="command" value="customer_change_pin">
			<table class="tblcenter">
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
			<br> <br>
			<p style="text-align: center;">
				<input type="submit" value="Change PIN"
					onclick="if (!(confirm('Are you sure you want to change the pin?'))) return false" style="background-color: #ac9362; margin-top:5px;  width: 50%;">
			</p>

		</form>
	</div>
	
	<p style="text-align:center;"><button style="background-color: #ac9362; width: 46%;" onClick="hide('pinchange')">Close</button></p>
	</div></div>

	<!-- ------------------------------------------------------------------------- -->
	
	<div  id="getcash" class="ontop">
	<div id="popup">
	
	
	<div class="center">
	
		<form action="Admin_Validation_Servlet" method="post" style="margin-top:20px;">
			<input type="hidden" name="command" value="get_cash">

			<table class="tblcenter">
				<tr>
					<td>Enter Amount to Withdraw</td>
					<td><input type="number" name="get_cash"></td>
				</tr>
			</table>
			<br> <br>
			<p style="text-align: center;">
				<input type="submit" value="Get Cash" style="background-color: #ac9362; margin-top:5px;  width: 50%;">
			</p>

		</form>
	</div>

	<p style="text-align:center;"><button style="background-color: #ac9362; width: 46%;" onClick="hide('getcash')">Close</button></p>
	</div></div>

	<!-- ------------------------------------------------------------------------- -->
	<!-- ------------------------------------------------------------------------- -->

	<div class="button-container">
		<form name="fastcash">
			<div>
				<input class="input" type="button" value="Withdrawal (Fast Cash)"
					onclick="pop('fastcash')">
			</div>
		</form>

		<form name="deposite">
			<div>
				<input class="input" type="button" value="Deposite"
					onclick="pop('deposit')">
			</div>
		</form>
	</div>
	<!-- ------------------------------------------------------------------------- -->
	
	<div  id="fastcash" class="ontop">
	<div id="popup">
	
	
	<div class="center">
	
		<h6 align="center"  style="margin-top:20px;">Select Amount to Withdraw</h6>
		<form action="Admin_Validation_Servlet" method="post">
			<input type="hidden" name="command" value="fast_cash">

			<table style="width: 100%; margin-top:20px;">
				<tr>
					<td><input class="cashbtn" type="submit" value="500"
						name="500" style="background-color: #ac9362;"></td>
					<td><input class="cashbtn" type="submit" value="1000"
						name="1000" style="background-color: #ac9362;"></td>
				</tr>
				<tr>
					<td><input class="cashbtn" type="submit" value="2000"
						name="2000" style="background-color: #ac9362;"></td>
					<td><input class="cashbtn" type="submit" value="5000"
						name="5000" style="background-color: #ac9362;"></td>
				</tr>
			</table>

		</form>
	</div>
	
	<p style="text-align:center;"><button style="margin-top:10px; background-color: #ac9362; width: 46%;" onClick="hide('fastcash')">Close</button></p>
	</div></div>

	<!-- ------------------------------------------------------------------------- -->
	
	<div  id="deposit" class="ontop">
	<div id="popup">
	
	
	<div class="center">
	
		<form action="Admin_Validation_Servlet" method="post" style="margin-top:20px;">
			<input type="hidden" name="command" value="customer_deposit">
			<table class="tblcenter">
				<tr>
					<td>Enter Amount</td>
					<td><input type="number" name="deposit_amount"></td>
				</tr>
			</table>
			<br> <br>
			<p style="text-align: center;">
				<input type="submit" value="Deposit" style="background-color: #ac9362; margin-top:5px;  width: 50%;">
			</p>
		</form>
	</div>

	<p style="text-align:center;"><button style="background-color: #ac9362; width: 46%;" onClick="hide('deposit')">Close</button></p>
	</div></div>

	<!-- ------------------------------------------------------------------------- -->
	<!-- ------------------------------------------------------------------------- -->

	<div class="button-container">
		<form action="Admin_Validation_Servlet" method="post"
			target="cust_iframe">
			<div>
				<input type="hidden" name="command" value="view_balance"> <input
					class="input" type="submit" name="view_balance"
					value="View Balance" onclick="viewBalanceForm()">
			</div>
		</form>

		<form action="Admin_Validation_Servlet" method="post"
			target="mini_stmt_iframe">
			<div>
				<input type="hidden" name="command" value="customer_mini_statement">
				<input class="input" type="submit" name="mini_statement"
					value="Mini Statement" onclick="miniStmtForm()">
			</div>
		</form>
	</div>
	<!-- ------------------------------------------------------------------------- -->

	<div id="viewbalance" style="display: none;">
		<iframe name="cust_iframe" style="height: 100px; width: 100%;"
			title="iframe"></iframe>
	</div>

	<!-- ------------------------------------------------------------------------- -->

	<div id="ministmt" style="display: none;">
		<iframe name="mini_stmt_iframe" style="height: 400px; width: 100%;"
			title="iframe"></iframe>
	</div>



	<!-- ------------------------------------------------------------------------- -->
	<!-- ------------------------------------------------------------------------- -->





</body>
</html>