<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Karnataka Bank</title>
<link rel="stylesheet" href="admin_gui_page_css.css" type="text/css">


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
	<!-- <a href="index.html">LOGOUT</a>
	<hr> -->
	<!-- --------------------------------------------------------------------------------------------------- -->


	<!-- 
<table>

<tr>
<td width="50%">
<form action="add_branch.jsp">
<input type="submit" name="add_branch" value="Add Bank Branch" >
</form>
</td>

<td width="50%">
<form action="create_customer_account.jsp">
<input type="submit" name="create_customer_account" value="Create Customer Account" >
</form>
</td>
</tr>


<tr>
<td width="50%">
<form action="modify_customer_account.jsp" method="post">
<input type="submit" name="modify_customer_details" value="Modify Customer Details" >
</form>
</td>

<td width="50%">
<form action="delete_customer_details.jsp">
<input type="submit" name="delete_customer_details" value="Delete Customer Details" >
</form>
</td>
</tr>


<tr>
<td width="50%">
<form action="customer_verify_clear_check.jsp">
<input type="submit" name="verify_and_clear_check" value="Verify and Clear Check" >
</form>
</td>

<td>
<form action="account_statement.jsp" method="post">
<input type="submit" name="generate_account_statement" value="Generate Account Statement" >
</form>
</td>
</tr>
</table>

 -->

	<script>
		function pop(div) {
			document.getElementById(div).style.display = 'block';
		}
		function hide(div) {
			document.getElementById(div).style.display = 'none';
		}
		//--------------------------------------------------------------------------------

		/*function createCustomerForm() {
			var x = document.getElementById("createcustomer");
			if (x.style.display === "none") {
				x.style.display = "block";
			} else {
				x.style.display = "none";
			}
		}
		//--------------------------------------------------------------------------------

		function modifyCustomerForm() {
			var x = document.getElementById("modifycustomer");
			if (x.style.display === "none") {
				x.style.display = "block";
			} else {
				x.style.display = "none";
			}
		}
		//--------------------------------------------------------------------------------

		function deleteCustomerForm() {
			var x = document.getElementById("deletecustomer");
			if (x.style.display === "none") {
				x.style.display = "block";
			} else {
				x.style.display = "none";
			}
		}
		//--------------------------------------------------------------------------------

		function clearCheckForm() {
			var x = document.getElementById("clearchecks");
			if (x.style.display === "none") {
				x.style.display = "block";
			} else {
				x.style.display = "none";
			}
		}
		//--------------------------------------------------------------------------------

		function accountStatementForm() {
			var x = document.getElementById("accountstmt");
			if (x.style.display === "none") {
				x.style.display = "block";
			} else {
				x.style.display = "none";
				document.getElementById("accstmt").style.display = "none";
			}
		}
			
		function accStmtDisplayForm() {
			var x = document.getElementById("accstmt");
			if (x.style.display === "none") {
				x.style.display = "block";
			} else {
				x.style.display = "none";
			}

		}*/
	</script>

	<!-- ------------------------------------------------------------------------- -->
	<!-- ------------------------------------------------------------------------- -->


	<div class="button-container" style="margin-top: 63px">
		<form name="add_branch">
			<div>
				<input class="input" type="button" value="Add Bank Branch"
					onclick="pop('addbranch')">
			</div>
		</form>

		<form name="create_customer">
			<div>
				<input class="input" type="button" value="Create Customer Account"
					onclick="pop('createcustomer')">
			</div>
		</form>
	</div>

	<!-- <div id="firstRow"></div>  -->
	<!-- ------------------------------------------------------------------------- -->

	<div id="addbranch" class="ontop">
		<div id="popup">


			<div class="center">
				<form action="Admin_Validation_Servlet" method="post">
					<input type="hidden" name="command" value="add_branch">
					<table class="tblcenter" style="margin-top: 10px;">
						<tr>
							<td>Branch Name</td>
							<td><input type="text" name="branch_name" required></td>
						</tr>
						<tr>
							<td>Branch State</td>
							<td><input type="text" name="branch_state" required></td>
						</tr>
					</table>
					<br> <br>
					<p style="text-align: center;">
						<input type="submit" value="Add Branch"
							onclick="if (!(confirm('Are you sure you want to add this branch?'))) return false"
							style="background-color: #ac9362; margin-top: 5px; width: 50%;">
					</p>
				</form>
			</div>

			<p style="text-align: center;">
				<button style="background-color: #ac9362; width: 46%;"
					onClick="hide('addbranch')">Close</button>
			</p>
		</div>
	</div>

	<!-- ------------------------------------------------------------------------- -->

	<div id="createcustomer" class="ontop">
		<div id="popup" style="height: 535px; top: 15%; margin-top: 0px">


			<div class="center">

				<form action="Admin_Validation_Servlet" method="post">

					<input type="hidden" name="command" value="add_customer">

					<table class="tblcenter">
						<tr>
							<td>Full Name</td>
							<td><input type="text" name="full_name"
								pattern="^[a-zA-Z]+ [a-zA-Z]+ [a-zA-Z]+$"
								title="Please Enter Full Name" required></td>
						</tr>

						<tr>
							<td>Fathers Name</td>
							<td><input type="text" name="fathers_name"
								pattern="^[a-zA-Z]+ [a-zA-Z]+ [a-zA-Z]+$"
								title="Please Enter Full Name" required></td>
						</tr>

						<tr>
							<td>Email ID</td>
							<td><input type="text" name="email_id"
								pattern="[a-zA-Z0-9_-.+]+@[a-zA-Z0-9-.]+([.][a-zA-z0-9]){2}"
								placeholder="abc@gmail.com" required></td>
						</tr>

						<tr>
							<td>Date Of Birth</td>
							<td><input type="text" name="dob" placeholder="yyyy-MM-dd"
								pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" required></td>
						</tr>

						<tr>
							<td>Gender</td>
							<td><input type="text" name="gender" pattern="[a-zA-Z]+"
								required></td>
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
							<td><input type="text" name="pan_number"
								pattern="[a-zA-Z0-9]{0,10}" required></td>
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
							<td><input type="text" name="account_type"
								pattern="([a-zA-z]+\s*[a-zA-z]*){0,10}" required></td>
						</tr>

						<tr>
							<td>CheckBook</td>
							<td><input type="radio" name="check_book" value="yes"
								checked>Yes <input type="radio" name="check_book"
								value="no">No</td>
						</tr>

					</table>
					<br> <br>
					<p style="text-align: center;">
						<input type="submit" value="Add Customer"
							onclick="if (!(confirm('Are you sure you want to add this customer?'))) return false"
							style="background-color: #ac9362; margin-top: 5px; width: 50%;">
					</p>
				</form>
			</div>


			<p style="text-align: center;">
				<button style="background-color: #ac9362; width: 46%;"
					onClick="hide('createcustomer')">Close</button>
			</p>
		</div>
	</div>

	<!-- ------------------------------------------------------------------------- -->
	<!-- ------------------------------------------------------------------------- -->

	<div class="button-container">
		<form name="modify_customer">
			<div>
				<input class="input" type="button" value="Modify Customer Details"
					onclick="pop('modifycustomer')">
			</div>
		</form>

		<form name="delete_customer">
			<div>
				<input class="input" type="button" value="Delete Customer Details"
					onclick="pop('deletecustomer')">
			</div>
		</form>
	</div>

	<!-- <div id="secondRow"></div> -->
	<!-- ------------------------------------------------------------------------- -->

	<div id="modifycustomer" class="ontop">
		<div id="popup">


			<div class="center">

				<form action="Admin_Validation_Servlet" method="post">
					<input type="hidden" name=command value="acc_no_to_modify">
					<table class="tblcenter" style="margin-top: 30px;">
						<tr>
							<td>Enter Account Number</td>
							<td><input type="number" name="acc_no" pattern="[0-9]{7}"
								title="Must contain 7 digit Account Number" required></td>
						</tr>
					</table>
					<br>
					<p style="text-align: center;">
						<input type="submit" value="Submit"
							onclick="if (!(confirm('Are you sure you want to modify this customer?'))) return false"
							style="background-color: #ac9362; margin-top: 5px; width: 50%;">
					</p>
				</form>
			</div>

			<p style="text-align: center;">
				<button style="background-color: #ac9362; width: 46%;"
					onClick="hide('modifycustomer')">Close</button>
			</p>
		</div>
	</div>

	<!-- ------------------------------------------------------------------------- -->

	<div id="deletecustomer" class="ontop">
		<div id="popup">


			<div class="center">

				<form action="Admin_Validation_Servlet" method="post">
					<input type="hidden" name="command" value="delete_customer">
					<p style="text-align: center; margin-top: 10px;">
						Enter CustomerID to delete <input type="number" name="customerId"
							pattern="[0-9]{7}" title="Must contain 7 digit account number"
							required>
					</p>
					<br>
					<p style="text-align: center;">
						<input type="submit" value="Delete"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false"
							style="background-color: #ac9362; margin-top: 5px; width: 50%;">
					</p>
				</form>
			</div>

			<p style="text-align: center;">
				<button style="background-color: #ac9362; width: 46%;"
					onClick="hide('deletecustomer')">Close</button>
			</p>
		</div>
	</div>

	<!-- ------------------------------------------------------------------------- -->
	<!-- ------------------------------------------------------------------------- -->

	<div class="button-container">
		<form name="clear_check">
			<div>
				<input class="input" type="button" value="Verify and Clear Check"
					onclick="pop('clearchecks')">
			</div>
		</form>

		<form name="account_stmt">
			<div>
				<input class="input" type="button"
					value="Generate Account Statement" onclick="pop('accountstmt')">
			</div>
		</form>
	</div>

	<!-- <div id="thirdRow"></div> -->

	<!-- ------------------------------------------------------------------------- -->

	<div id="clearchecks" class="ontop">
		<div id="popup">


			<div class="center">

				<form action="Admin_Validation_Servlet" method="post">
					<input type="hidden" name="command" value="check_clear">
					<table class="tblcenter">
						<tr>
							<td>Account Number</td>
							<td><input type="number" name="acc_no" pattern="[0-9]{7}"
								title="Must contain 7 digit account number" required></td>
						</tr>
						<tr>
							<td>Check Number</td>
							<td><input type="number" name="check_number" required></td>
						</tr>
						<tr>
							<td>Amount</td>
							<td><input type="number" name="check_amount" required></td>
						</tr>

					</table>
					<br>
					<p style="text-align: center;">
						<input type="submit" value="Clear Check"
							onclick="if (!(confirm('Are you sure you want to clear this check?'))) return false"
							style="background-color: #ac9362; margin-top: 5px; width: 50%;">
					</p>
				</form>
			</div>

			<p style="text-align: center;">
				<button style="background-color: #ac9362; width: 46%;"
					onClick="hide('clearchecks')">Close</button>
			</p>
		</div>
	</div>

	<!-- ------------------------------------------------------------------------- -->

	<div id="accountstmt" class="ontop">
		<div id="popup">


			<div class="center">

				<form action="Admin_Validation_Servlet" method="post">
					<input type="hidden" name="command" value="account_statement">
					<table class="tblcenter">
						<tr>
							<td>Enter Customer ID</td>
							<td><input type="number" name="customer_id"
								name="customerId" pattern="[0-9]{7}"
								title="Must contain 7 digit account number" required></td>
						</tr>
						<tr>
							<td>From Date</td>
							<td><input type="text" name="from_date"
								placeholder="yyyy/MM/dd" pattern="[0-9]{4}/[0-9]{2}/[0-9]{2}"
								required>
						</tr>
						<tr>
							<td>To Date</td>
							<td><input type="text" name="to_date"
								placeholder="yyyy/MM/dd" pattern="[0-9]{4}/[0-9]{2}/[0-9]{2}"
								required>
						</tr>
					</table>
					<br> <br>
					<p style="text-align: center;">
						<input type="submit" value="Generate Account Statement"
							onclick="accStmtDisplayForm()"
							style="background-color: #ac9362; margin-top: 5px; width: 50%;">
					</p>


				</form>
			</div>

			<p style="text-align: center;">
				<button style="background-color: #ac9362; width: 46%;"
					onClick="hide('accountstmt')">Close</button>
			</p>
		</div>
	</div>
	<!-- ------------------------------------------------------------------------- -->


	<!-- 
	<div id="accstmt" style="display: none;">
		<iframe name="acc_stmt_iframe"
			style="height: 400px; width: 100%;" title="iframe"></iframe>
	</div>
	 -->
	<!-- ------------------------------------------------------------------------- -->
	<!-- ------------------------------------------------------------------------- -->



























































	<!-- 
	<div class="button-container" style="margin-top: 63px">
		<form action="add_branch.jsp" target="admin_iframe">
			<div>
				<input class="input" type="submit" name="add_branch"
					value="Add Bank Branch">
			</div>
		</form>

		<form action="create_customer_account.jsp" target="admin_iframe">
			<div>
				<input class="input" type="submit" name="create_customer_account"
					value="Create Customer Account">
			</div>
		</form>
	</div>

	<div class="button-container">
		<form action="customer_acc_no_to_modify.jsp" target="admin_iframe">
			<div>
				<input class="input" type="submit" name="modify_customer_details"
					value="Modify Customer Details">
			</div>
		</form>

		<form action="delete_customer_details.jsp" target="admin_iframe">
			<div>
				<input class="input" type="submit" name="delete_customer_details"
					value="Delete Customer Details">
			</div>
		</form>
	</div>

	<div class="button-container">
		<form action="customer_verify_clear_check.jsp" target="admin_iframe">
			<div>
				<input class="input" type="submit" name="verify_and_clear_check"
					value="Verify and Clear Check">
			</div>
		</form>

		<form action="account_statement.jsp" target="admin_iframe">
			<div>
				<input class="input" type="submit" name="generate_account_statement"
					value="Generate Account Statement">
			</div>
		</form>
	</div>




	<iframe src="default_page.html" name="admin_iframe"
		style="height: 500px; width: 100%;" title="Iframe for dynamic forms"></iframe>


 -->

	<!-- -------------------------------------------------------------------------------- -->

	<!-- 
	<p id="GFG_DOWN"></p>


	<script type="text/javascript">
		var down = document.getElementById("GFG_DOWN");

		// Create a break line element 
		var br = document.createElement("br");
		
		// function for Add Branch
		function Add_Branch() {

			// Create a form dynamically 
			var form = document.createElement("form");
			form.setAttribute("method", "post");
			form.setAttribute("action", "Admin_Validation_Servlet");

			// Create an input element for hidden value 
			var Hidden = document.createElement("input");
			Hidden.setAttribute("type", "hidden");
			Hidden.setAttribute("name", "command");
			Hidden.setAttribute("value", "add_branch");

			// Create an input element for branch name 
			var BranchName = document.createElement("input");
			BranchName.setAttribute("type", "text");
			BranchName.setAttribute("name", "branch_name");
			BranchName.setAttribute("placeholder", "Branch Name");
			//BranchName.setAttribute("pattern", "^[a-zA-Z]+[/s]*[a-zA-Z]*");
			BranchName
					.setAttribute(
							"title",
							"Your Branch name can contain UpperCase letters, LowerCase letters");
			BranchName.setAttribute("required");

			// Create an input element for branch state 
			var BranchState = document.createElement("input");
			BranchState.setAttribute("type", "text");
			BranchState.setAttribute("name", "branch_state");
			BranchState.setAttribute("placeholder", "Branch State");
			//BranchState.setAttribute("pattern", "^[a-zA-Z]+[/s]*[a-zA-Z]*");
			BranchState
					.setAttribute(
							"title",
							"Your State name can contain UpperCase letters, LowerCase letters");
			BranchState.setAttribute("required");

			// create a submit Add Branch 
			var AddBranchButton = document.createElement("input");
			AddBranchButton.setAttribute("type", "submit");
			AddBranchButton.setAttribute("value", "Add Branch");

			// Append the full name input to the form 
			form.appendChild(Hidden);

			// Inserting a line break 
			form.appendChild(br.cloneNode());

			// Append the DOB to the form 
			form.appendChild(BranchName);
			form.appendChild(br.cloneNode());

			// Append the emailID to the form 
			form.appendChild(BranchState);
			form.appendChild(br.cloneNode());

			// Append the submit button to the form 
			form.appendChild(AddBranchButton);

			document.getElementsByTagName("body")[0].appendChild(form);
		}

		
		// finction for Add Customer
		function Add_Customer() {

			// Create a form dynamically 
			var form = document.createElement("form");
			form.setAttribute("method", "post");
			form.setAttribute("action", "Admin_Validation_Servlet");

			// Create an input element for hidden value 
			var Hidden = document.createElement("input");
			Hidden.setAttribute("type", "hidden");
			Hidden.setAttribute("name", "command");
			Hidden.setAttribute("value", "add_customer");

			// Create an input element for customers name 
			var FullName = document.createElement("input");
			FullName.setAttribute("type", "text");
			FullName.setAttribute("name", "full_name");
			FullName.setAttribute("placeholder", "Customer Full Name");
			FullName.setAttribute("pattern", "^[a-zA-Z]+ [a-zA-Z]+ [a-zA-Z]+$");
			FullName.setAttribute("required");

			// Create an input element for fathers name 
			var Fathersname = document.createElement("input");
			Fathersname.setAttribute("type", "text");
			Fathersname.setAttribute("name", "fathers_name");
			Fathersname.setAttribute("placeholder", "Fathers Name");
			Fathersname.setAttribute("pattern", "^[a-zA-Z]+ [a-zA-Z]+ [a-zA-Z]+$");
			Fathersname.setAttribute("required");

			// Create an input element for DOB
			var DOB = document.createElement("input");
			DOB.setAttribute("type", "text");
			DOB.setAttribute("name", "dob");
			DOB.setAttribute("placeholder", "DOB yyyy-MM-dd");
			DOB.setAttribute("pattern", "[0-9]{4}-[0-9]{2}-[0-9]{2}");
			DOB.setAttribute("required");

			// Create an input element for Gender
			var Gender = document.createElement("input");
			Gender.setAttribute("type", "text");
			Gender.setAttribute("name", "gender");
			Gender.setAttribute("placeholder", "Gender");
			Gender.setAttribute("pattern", "[a-zA-Z]+");
			Gender.setAttribute("required");

			// Create an input element for Permanent Address
			var PermanentAddress = document.createElement("input");
			PermanentAddress.setAttribute("type", "text");
			PermanentAddress.setAttribute("name", "permanent_address");
			PermanentAddress.setAttribute("placeholder", "Permanent Address");
			
			PermanentAddress.setAttribute("required");

			// Create an input element for Present Address
			var PresentAddress = document.createElement("input");
			PresentAddress.setAttribute("type", "text");
			PresentAddress.setAttribute("name", "present_address");
			PresentAddress.setAttribute("placeholder", "Present Address");
			
			PresentAddress.setAttribute("required");

			// Create an input element for PAN Number
			var PANNumber = document.createElement("input");
			PANNumber.setAttribute("type", "text");
			PANNumber.setAttribute("name", "pan_number");
			PANNumber.setAttribute("placeholder", "PAN Number");
			PANNumber.setAttribute("pattern", "[a-zA-Z0-9]{0,10}");
			PANNumber.setAttribute("required");

			// Create an input element for Mobile Number
			var MobileNumber = document.createElement("input");
			MobileNumber.setAttribute("type", "tel");
			MobileNumber.setAttribute("name", "mobile_number");
			MobileNumber.setAttribute("placeholder", "Mobile Number");
			
			MobileNumber.setAttribute("required");
			
			// Create an input element for Landline
			var Landline = document.createElement("input");
			Landline.setAttribute("type", "tel");
			Landline.setAttribute("name", "landline");
			Landline.setAttribute("placeholder", "Landline Number");
			
			Landline.setAttribute("required");

			// Create an input element for Account Type
			var AccountType = document.createElement("input");
			AccountType.setAttribute("type", "text");
			AccountType.setAttribute("name", "account_type");
			AccountType.setAttribute("placeholder", "Account Type");
			AccountType.setAttribute("pattern", "([a-zA-z]+\s*[a-zA-z]*){0,10}");
			AccountType.setAttribute("required");
			
			// create an input element for check book yes or no
			var CheckBook = document.createElement("input");
			CheckBook.setAttribute("type", "text");
			CheckBook.setAttribute("name", "check_book");
			CheckBook.setAttribute("placeholder", "Check Book (Yes or No)");
			CheckBook.setAttribute("pattern", "[a-zA-z]+");
			CheckBook.setAttribute("required");
			
			

			/*
			// Create an input element for Check Book
			var CheckBook = document.createElement("input");
			CheckBook.setAttribute("type", "radio");
			CheckBook.setAttribute("name", "check_book");
			CheckBook.setAttribute("id", "yes")
			CheckBook.setAttribute("value", "yes");
			//CheckBook.setAttribute("Yes");
			
			
			
			

			var Lable1 = document.createElement("label");
			Label1.setAttribute("id","myLabel1");
			Label1.setAttribute("for", "yes");
			var text1 = document.createTextNode("Yes");
			//Label1.setAttribute("Yes");

			// for check book 2nd radio button
			var CheckBook1 = document.createElement("input");
			CheckBook1.setAttribute("type", "radio");
			CheckBook1.setAttribute("name", "check_book");
			CheckBook1.setAttribute("id", "no")
			CheckBook1.setAttribute("value", "no");
			//CheckBook1.setAttribute("No");
			
			// text for cradio button
			var text2 = document.createTextNode("No");

			//var Lable2 = document.createElement("label");
			//Lable2.setAttribute("for", "no");
			//Lable2.setAttribute("No");
			*/
			
			
			/*var gender = ['Yes', 'No'];
			   gender.forEach((genederValue, i) => {
			      var labelValue = document.createElement('label');
			      labelValue.innerHTML = genederValue;
			      var inputValue = document.createElement('input');
			      inputValue.type = "radio";
			      inputValue.name = genederValue;
			      inputValue.genederValue = i;
			      document.body.appendChild(labelValue);
			      document.body.appendChild(inputValue);
			   });*/
			
			
			
			
			// create a submit button 
			var CreateCustomerButton = document.createElement("input");
			CreateCustomerButton.setAttribute("type", "submit");
			CreateCustomerButton.setAttribute("value", "Create Customer");

			// Append the hidden input to the form 
			form.appendChild(Hidden);
			// Inserting a line break 
			form.appendChild(br.cloneNode());

			// Append the FullName to the form 
			form.appendChild(FullName);
			form.appendChild(br.cloneNode());

			// Append the Fathersname to the form 
			form.appendChild(Fathersname);
			form.appendChild(br.cloneNode());

			// Append the DOB to the form 
			form.appendChild(DOB);
			form.appendChild(br.cloneNode());

			// Append the Gender to the form 
			form.appendChild(Gender);
			form.appendChild(br.cloneNode());

			// Append the PermanentAddress to the form 
			form.appendChild(PermanentAddress);
			form.appendChild(br.cloneNode());

			// Append the PresentAddress to the form 
			form.appendChild(PresentAddress);
			form.appendChild(br.cloneNode());

			// Append the PANNumber to the form 
			form.appendChild(PANNumber);
			form.appendChild(br.cloneNode());

			// Append the MobileNumber to the form 
			form.appendChild(MobileNumber);
			form.appendChild(br.cloneNode());

			// Append the Landline to the form 
			form.appendChild(Landline);
			form.appendChild(br.cloneNode());
			
			// Append the AccountType to the form 
			form.appendChild(AccountType);
			form.appendChild(br.cloneNode());
			

			/*
			// Append the CheckBook to the form 
			form.appendChild(CheckBook);

			// Append the Lable1 to the form 
			form.appendChild(Lable1);
			
			// Append the text for radio button yes
			form.appendChild(text1);

			// Append the CheckBook1 to the form 
			form.appendChild(CheckBook1);

			// Append the Lable2 to the form 
			form.appendChild(Lable2);
			

			// Append the text for radio button yes
			form.appendChild(text2);
			*/
			
			
			// Append the CheckBook to the form 
			form.appendChild(CheckBook);
			form.appendChild(br.cloneNode());

			// Append the submit button to the form 
			form.appendChild(CreateCustomerButton);

			document.getElementsByTagName("body")[0].appendChild(form);
		}
		
		
		
		
		// function to modify customer details
		function Modify_Customer(){
			
			// Create a form dynamically 
			var form = document.createElement("form");
			form.setAttribute("method", "post");
			form.setAttribute("action", "Admin_Validation_Servlet");

			// Create an input element for hidden value 
			var Hidden = document.createElement("input");
			Hidden.setAttribute("type", "hidden");
			Hidden.setAttribute("name", "command");
			Hidden.setAttribute("value", "modify_customer");

			// Create an input element for CustomerID 
			var CustomerID = document.createElement("input");
			CustomerID.setAttribute("type", "number");
			CustomerID.setAttribute("name", "customerId");
			CustomerID.setAttribute("placeholder", "Customer ID");
			CustomerID.setAttribute("required");
			
			// Create an input element for customers name 
			var FullName = document.createElement("input");
			FullName.setAttribute("type", "text");
			FullName.setAttribute("name", "full_name");
			FullName.setAttribute("placeholder", "Customer Full Name");
			FullName.setAttribute("pattern", "^[a-zA-Z]+ [a-zA-Z]+ [a-zA-Z]+$");
			FullName.setAttribute("required");

			// Create an input element for fathers name 
			var Fathersname = document.createElement("input");
			Fathersname.setAttribute("type", "text");
			Fathersname.setAttribute("name", "fathers_name");
			Fathersname.setAttribute("placeholder", "Fathers Name");
			Fathersname.setAttribute("pattern", "^[a-zA-Z]+ [a-zA-Z]+ [a-zA-Z]+$");
			Fathersname.setAttribute("required");

			// Create an input element for DOB
			var DOB = document.createElement("input");
			DOB.setAttribute("type", "text");
			DOB.setAttribute("name", "dob");
			DOB.setAttribute("placeholder", "DOB yyyy-MM-dd");
			DOB.setAttribute("pattern", "[0-9]{4}-[0-9]{2}-[0-9]{2}");
			DOB.setAttribute("required");

			// Create an input element for Gender
			var Gender = document.createElement("input");
			Gender.setAttribute("type", "text");
			Gender.setAttribute("name", "gender");
			Gender.setAttribute("placeholder", "Gender");
			Gender.setAttribute("pattern", "[a-zA-Z]+");
			Gender.setAttribute("required");

			// Create an input element for Permanent Address
			var PermanentAddress = document.createElement("input");
			PermanentAddress.setAttribute("type", "text");
			PermanentAddress.setAttribute("name", "permanent_address");
			PermanentAddress.setAttribute("placeholder", "Permanent Address");
			
			PermanentAddress.setAttribute("required");

			// Create an input element for Present Address
			var PresentAddress = document.createElement("input");
			PresentAddress.setAttribute("type", "text");
			PresentAddress.setAttribute("name", "present_address");
			PresentAddress.setAttribute("placeholder", "Present Address");
			
			PresentAddress.setAttribute("required");

			// Create an input element for PAN Number
			var PANNumber = document.createElement("input");
			PANNumber.setAttribute("type", "text");
			PANNumber.setAttribute("name", "pan_number");
			PANNumber.setAttribute("placeholder", "PAN Number");
			PANNumber.setAttribute("pattern", "[a-zA-Z0-9]{0,10}");
			PANNumber.setAttribute("required");

			// Create an input element for Mobile Number
			var MobileNumber = document.createElement("input");
			MobileNumber.setAttribute("type", "tel");
			MobileNumber.setAttribute("name", "mobile_number");
			MobileNumber.setAttribute("placeholder", "Mobile Number");
			
			MobileNumber.setAttribute("required");
			
			// Create an input element for Landline
			var Landline = document.createElement("input");
			Landline.setAttribute("type", "tel");
			Landline.setAttribute("name", "landline");
			Landline.setAttribute("placeholder", "Landline Number");
			
			Landline.setAttribute("required");

			// Create an input element for Account Type
			var AccountType = document.createElement("input");
			AccountType.setAttribute("type", "text");
			AccountType.setAttribute("name", "account_type");
			AccountType.setAttribute("placeholder", "Account Type");
			AccountType.setAttribute("pattern", "([a-zA-z]+\s*[a-zA-z]*){0,10}");
			AccountType.setAttribute("required");
			
			
			// create an input element for check book yes or no
			var CheckBook = document.createElement("input");
			CheckBook.setAttribute("type", "text");
			CheckBook.setAttribute("name", "check_book");
			CheckBook.setAttribute("placeholder", "Check Book (Yes or No)");
			CheckBook.setAttribute("pattern", "[a-zA-z]+");
			CheckBook.setAttribute("required");
			
			// create a submit button 
			var ModifyCustomerButton = document.createElement("input");
			ModifyCustomerButton.setAttribute("type", "submit");
			ModifyCustomerButton.setAttribute("value", "Modify Customer");

			// Append the hidden input to the form 
			form.appendChild(Hidden);
			// Inserting a line break 
			form.appendChild(br.cloneNode());
			
			// Append the CustomerID to the form 
			form.appendChild(CustomerID);
			form.appendChild(br.cloneNode());

			// Append the FullName to the form 
			form.appendChild(FullName);
			form.appendChild(br.cloneNode());

			// Append the Fathersname to the form 
			form.appendChild(Fathersname);
			form.appendChild(br.cloneNode());

			// Append the DOB to the form 
			form.appendChild(DOB);
			form.appendChild(br.cloneNode());

			// Append the Gender to the form 
			form.appendChild(Gender);
			form.appendChild(br.cloneNode());

			// Append the PermanentAddress to the form 
			form.appendChild(PermanentAddress);
			form.appendChild(br.cloneNode());

			// Append the PresentAddress to the form 
			form.appendChild(PresentAddress);
			form.appendChild(br.cloneNode());

			// Append the PANNumber to the form 
			form.appendChild(PANNumber);
			form.appendChild(br.cloneNode());

			// Append the MobileNumber to the form 
			form.appendChild(MobileNumber);
			form.appendChild(br.cloneNode());

			// Append the Landline to the form 
			form.appendChild(Landline);
			form.appendChild(br.cloneNode());
			
			// Append the AccountType to the form 
			form.appendChild(AccountType);
			form.appendChild(br.cloneNode());
			
			// Append the CheckBook to the form 
			form.appendChild(CheckBook);
			form.appendChild(br.cloneNode());

			// Append the submit button to the form 
			form.appendChild(ModifyCustomerButton);

			document.getElementsByTagName("body")[0].appendChild(form);
		}
			
			
			
			// function to modify customer details
			function Delete_Customer(){
				
				// Create a form dynamically 
				var form = document.createElement("form");
				form.setAttribute("method", "post");
				form.setAttribute("action", "Admin_Validation_Servlet");

				// Create an input element for hidden value 
				var Hidden = document.createElement("input");
				Hidden.setAttribute("type", "hidden");
				Hidden.setAttribute("name", "command");
				Hidden.setAttribute("value", "delete_customer");

				// Create an input element for CustomerID 
				var CustomerID = document.createElement("input");
				CustomerID.setAttribute("type", "number");
				CustomerID.setAttribute("name", "customerId");
				CustomerID.setAttribute("placeholder", "Customer ID");
				CustomerID.setAttribute("required");
				
				// create a submit button 
				var DeleteCustomerButton = document.createElement("input");
				DeleteCustomerButton.setAttribute("type", "submit");
				DeleteCustomerButton.setAttribute("value", "Delete Customer");
				DeleteCustomerButton.setAttribute("onclick", "if (!(confirm('Are you sure you want to delete this customer?'))) return false");
			
				// Append the hidden input to the form 
				form.appendChild(Hidden);
				// Inserting a line break 
				form.appendChild(br.cloneNode());
				
				// Append the CustomerID to the form 
				form.appendChild(CustomerID);
				form.appendChild(br.cloneNode());
				
				// Append the submit button to the form 
				form.appendChild(DeleteCustomerButton);

				document.getElementsByTagName("body")[0].appendChild(form);
				
				
		}
			
			
			// function to modify customer details
			function Verify_Clear_Check(){
				
				// Create a form dynamically 
				var form = document.createElement("form");
				form.setAttribute("method", "post");
				form.setAttribute("action", "Admin_Validation_Servlet");

				// Create an input element for hidden value 
				var Hidden = document.createElement("input");
				Hidden.setAttribute("type", "hidden");
				Hidden.setAttribute("name", "command");
				Hidden.setAttribute("value", "check_clear");

				// Create an input element for CustomerID 
				var CustomerID = document.createElement("input");
				CustomerID.setAttribute("type", "number");
				CustomerID.setAttribute("name", "customerId");
				CustomerID.setAttribute("placeholder", "Customer ID");
				CustomerID.setAttribute("required");
				
				// Create an input element for Check Number
				var CheckNumber = document.createElement("input");
				CheckNumber.setAttribute("type", "number");
				CheckNumber.setAttribute("name", "check_number");
				CheckNumber.setAttribute("placeholder", "Check Number");
				CheckNumber.setAttribute("required");
				
				// Create an input element for Check Amount
				var CheckAmount = document.createElement("input");
				CheckAmount.setAttribute("type", "number");
				CheckAmount.setAttribute("name", "check_amount");
				CheckAmount.setAttribute("placeholder", "Check Amount");
				CheckAmount.setAttribute("required");
				
				// create a submit button 
				var ClearCheckButton = document.createElement("input");
				ClearCheckButton.setAttribute("type", "submit");
				ClearCheckButton.setAttribute("value", "Clear Check");
				
				// Append the hidden input to the form 
				form.appendChild(Hidden);
				// Inserting a line break 
				form.appendChild(br.cloneNode());
				
				// Append the CustomerID to the form 
				form.appendChild(CustomerID);
				form.appendChild(br.cloneNode());
				
				// Append the Check Number to the form 
				form.appendChild(CheckNumber);
				form.appendChild(br.cloneNode());
				
				// Append the Check Amount to the form 
				form.appendChild(CheckAmount);
				form.appendChild(br.cloneNode());
				
				// Append the submit button to the form 
				form.appendChild(ClearCheckButton);

				document.getElementsByTagName("body")[0].appendChild(form);
			}
				
			
			function Generate_Account_Statement(){
				
				// Create a form dynamically 
				var form = document.createElement("form");
				form.setAttribute("method", "post");
				form.setAttribute("action", "Admin_Validation_Servlet");

				// Create an input element for hidden value 
				var Hidden = document.createElement("input");
				Hidden.setAttribute("type", "hidden");
				Hidden.setAttribute("name", "command");
				Hidden.setAttribute("value", "account_statement");

				// Create an input element for CustomerID 
				var CustomerID = document.createElement("input");
				CustomerID.setAttribute("type", "number");
				CustomerID.setAttribute("name", "customerId");
				CustomerID.setAttribute("placeholder", "Customer ID");
				CustomerID.setAttribute("required");
				
				// Create an input element for customers name 
				var FromDate = document.createElement("input");
				FromDate.setAttribute("type", "text");
				FromDate.setAttribute("name", "from_date");
				FromDate.setAttribute("placeholder", "From Date (yyyy/MM/dd)");
				FromDate.setAttribute("pattern", "[0-9]{4}/[0-9]{2}/[0-9]{2}");
				FromDate.setAttribute("required");

				// Create an input element for fathers name 
				var ToDate = document.createElement("input");
				ToDate.setAttribute("type", "text");
				ToDate.setAttribute("name", "to_date");
				ToDate.setAttribute("placeholder", "To Date (yyyy/MM/dd)");
				ToDate.setAttribute("pattern", "[0-9]{4}/[0-9]{2}/[0-9]{2}");
				ToDate.setAttribute("required");
				
				// create a submit button 
				var AccountStatementButton = document.createElement("input");
				AccountStatementButton.setAttribute("type", "submit");
				AccountStatementButton.setAttribute("value", "Generate Account Statement");
				
				// Append the hidden input to the form 
				form.appendChild(Hidden);
				// Inserting a line break 
				form.appendChild(br.cloneNode());
				
				// Append the CustomerID to the form 
				form.appendChild(CustomerID);
				form.appendChild(br.cloneNode());

				// Append the FullName to the form 
				form.appendChild(FromDate);
				form.appendChild(br.cloneNode());

				// Append the Fathersname to the form 
				form.appendChild(ToDate);
				form.appendChild(br.cloneNode());
				
				
				// Append the submit button to the form 
				form.appendChild(AccountStatementButton);

				document.getElementsByTagName("body")[0].appendChild(form);
			}
	</script>
	 -->


</body>
</html>