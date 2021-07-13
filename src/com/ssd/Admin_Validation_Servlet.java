package com.ssd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class Admin_Validation
 */
@WebServlet("/Admin_Validation_Servlet")
public class Admin_Validation_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private AdminDbUtil adminDbUtil;

	@Resource(name = "jdbc/automatedtellermachine") // connection pool / DataSource
	private DataSource dataSource; // tomcat server will inject that conn pool object and assign here this variable
									// datasource

	private String host;
	private String port;
	private String user;
	private String pass;

	// initialize AdminDbUtil
	// override init() method of GenericServlet
	@Override
	public void init() throws ServletException {
		super.init();

		// reads SMTP server setting from web.xml file to send email
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");

		/*
		 * System.out.println(host); System.out.println(port); System.out.println(user);
		 * System.out.println(pass);
		 */

		// create our Admin db util...and pass in the conn pool / datasource
		try {
			adminDbUtil = new AdminDbUtil(dataSource);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	/*
	 * public void init() { // reads SMTP server setting from web.xml file
	 * ServletContext context = getServletContext(); host =
	 * context.getInitParameter("host"); port = context.getInitParameter("port");
	 * user = context.getInitParameter("user"); pass =
	 * context.getInitParameter("pass"); }
	 */

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * try { // read the "command" parameter String theCommand =
	 * request.getParameter("command");
	 * 
	 * // if the command is missing, then default to listing students if (theCommand
	 * == null) { response.sendRedirect("admin_gui_page.jsp");
	 * 
	 * } else if (theCommand == "modify_customer") {
	 * System.out.println(request.getParameter("customerId"));
	 * modifyCustomer(request, response); }
	 * 
	 * } catch (Exception e) { throw new ServletException(e); }
	 * 
	 * }
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");

			// if the command is missing, then default to listing students
			if (theCommand == null) {
				response.sendRedirect("index.html");
			}

			// route to the appropriate method
			switch (theCommand) {
			case "verify_admin":
				verifyAdmins(request, response);
				break;

			case "add_branch":
				addBranch(request, response);
				break;

			case "add_customer":
				addCustomer(request, response);
				break;

			case "lsit_customer":
				listCustomer(request, response);
				break;

			case "acc_no_to_modify":
				pre_modify_customer(request, response);
				break;

			case "modify_customer":
				modifyCustomer(request, response);
				break;

			case "delete_customer":
				deleteCustomer(request, response);
				break;

			case "verify_customer":
				verifyCustomers(request, response);
				break;

			case "customer_change_pin":
				changeCustomerPin(request, response);
				break;

			case "customer_deposit":
				depositMoney(request, response);
				break;

			case "get_cash":
				getCash(request, response);
				break;

			case "fast_cash":
				fastCash(request, response);
				break;

			case "view_balance":
				getBalance(request, response);
				break;

			case "check_clear":
				clearCheck(request, response);
				break;

			case "customer_mini_statement":
				customer_mini_statement(request, response);
				break;

			case "account_statement":
				accountStatement(request, response);
				break;

			default:
				response.sendRedirect("index.html");
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}

		/*
		 * // don't follow this pattern always follow above pattern(switch-case) // list
		 * the students ... in MVC fashion try { verifyAdmins(request, response); }
		 * catch (Exception e) { e.printStackTrace(); }
		 * 
		 * try { addBranch(request, response); } catch (Exception e) {
		 * e.printStackTrace(); }
		 * 
		 * try { addCustomer(request, response); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */

	}

	private void pre_modify_customer(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read account no from customer_acc_no_to_modify.jsp
		int acc_no = Integer.parseInt(request.getParameter("acc_no"));

		// get acc_no by calling List<Customer> getCustomers() method to check if it is
		// present or not
		List<Customer> customers = adminDbUtil.getCustomers();

		boolean flag = false;
		// check acc_no present or not
		for (Customer customer : customers) {

			if (acc_no == customer.getAcc_no()) {
				flag = true;
				break;
			}
		}

		if (flag == true) {

			// get customer object from db using AdminDbUtil
			Customer customer_info = adminDbUtil.getCustomerUsingAccNo(acc_no);

			// place object in the request
			request.setAttribute("CUSTOMER_MODIFY_INFO", customer_info);

			// send this object to modify_customer_account.jsp for pre-populated form
			RequestDispatcher dispatcher = request.getRequestDispatcher("modify_customer_account.jsp");
			dispatcher.forward(request, response);
		} else {
			PrintWriter pWriter = response.getWriter();
			pWriter.println("<script type=\"text/javascript\">");
			pWriter.print("alert('Invalid Account Number. Please Enter Valid Account Number!!!');");
			pWriter.println("location='admin_gui_page.jsp';"); // here i need to add default advertise page
			pWriter.println("</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("customer_acc_no_to_modify.jsp"); // here i need
																											// to add
			// default advertise
			// page
			dispatcher.include(request, response);
		}

	}

	private void accountStatement(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get account_no, from_date and to_date from request
		int customer_id = Integer.parseInt(request.getParameter("customer_id"));
		String from_date = request.getParameter("from_date");
		String to_date = request.getParameter("to_date");
		PrintWriter pWriter = response.getWriter();

		// check customerId is valid or not
		// call List<Customer> validateCustomers()
		List<Customer> customers = adminDbUtil.validateCustomers();

		boolean flag = false;
		// compare customer_id with all customerId's
		for (Customer customer : customers) {
			if (customer_id == customer.getCustomerId()) {
				flag = true;
				break;
			}
		}

		// if matched then perform above operations
		if (flag == true) {

			// get card_no to get balance and display balance
			Integer card_no = adminDbUtil.getCardNo(customer_id);
			double balance = adminDbUtil.getBalance(customer_id);

			// get transactions list from admin db util for date and transaction using
			// customerId
			List<Transactions> transactions = adminDbUtil.getTransactionForAccountStatement(card_no, from_date,
					to_date);

			// check if List of transactions is empty
			// if it is empty then show alert and dispatch to account_statement.jsp again
			if (transactions.isEmpty()) {

				pWriter.println("<script type=\"text/javascript\">");
				pWriter.println("alert('Customer has No Transactions in this Period');");
				pWriter.println("location='admin_gui_page.jsp';");
				pWriter.println("</script>");
				/*
				 * RequestDispatcher dispatcher =
				 * request.getRequestDispatcher("admin_gui_page.jsp");
				 * dispatcher.include(request, response);
				 */
			} else {
				// get other details from admin db util by customer object using customerId
				Customer customers_info = adminDbUtil.getCustomerInfo(customer_id);

				// pass above 2 objects by adding into arraylist via request to
				// display_account_statement.jsp
				List<Object> objects = new ArrayList<Object>();
				objects.add(transactions);
				objects.add(customers_info);
				objects.add(balance);

				// pass this list object to display_account_statement.jsp
				request.setAttribute("ACCOUNT_STATEMENT", objects);
				RequestDispatcher dispatcher = request.getRequestDispatcher("display_account_statement.jsp");
				dispatcher.include(request, response);
			}

		}
		// else show alert
		else {
			pWriter.println("<script type=\"text/javascript\">");
			pWriter.println("alert('Invalid Customer ID');");
			pWriter.println("location='admin_gui_page.jsp';");
			pWriter.println("</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin_gui_page.jsp");
			dispatcher.include(request, response);
		}

	}

	private void customer_mini_statement(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get card number from session
		HttpSession session = request.getSession(false);
		Customer customer = (Customer) session.getAttribute("customer_info");
		int session_card_no = customer.getCard_no();
		PrintWriter pWriter = response.getWriter();

		// using card no retrieve data from transactions table using AdminDbUtil
		List<Transactions> transactions = adminDbUtil.customer_mini_statement(session_card_no);

		if (transactions.isEmpty()) {
			pWriter.println("<script type =\"text/javascript\">");
			pWriter.println("alert('You have not done any Transaction yet!!');");
			pWriter.println("</script>");
		} else {
			// add transactions into request
			request.setAttribute("MINI_STATEMENT", transactions);

			// send this list object to customer_mini_statement.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("customer_mini_statement.jsp");
			dispatcher.include(request, response);
		}

	}

	// for admin_gui_page.jsp Verify and Clear Check button
	private void clearCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get customerId, check_number and check_amount from request coming from
		// customer_verify_clear_check.jsp
		int acc_no = Integer.parseInt(request.getParameter("acc_no"));
		int check_number = Integer.parseInt(request.getParameter("check_number"));
		String check_amount = request.getParameter("check_amount");
		double double_check_amount = Double.parseDouble(request.getParameter("check_amount"));
		PrintWriter pWriter = response.getWriter();

		// first check customerId is valid or not
		// get all customer id by calling List<Customer> getCustomers() method
		List<Customer> customers = adminDbUtil.getCustomers();

		boolean check = false;
		int customerId = 0;
		// compare customerId with all customerId's
		for (Customer customer : customers) {
			if (acc_no == customer.getAcc_no()) {
				customerId = customer.getCustomerId();
				check = true;
				break;
			}
		}

		if (check == true) {

			// get card_number from customer_account_details using customerId
			int card_number = adminDbUtil.getCardNo(customerId);

			// check customerid and check number match or not
			boolean flag = adminDbUtil.clearCheck(customerId, check_number);

			// if flag is false display current balance else display check_number is invalid

			if (flag == true) {
				// writer.println("Invalid Check Number");

				pWriter.println("<script type=\"text/javascript\">");
				pWriter.print("alert('Invalid Check Number');");
				pWriter.println("location='admin_gui_page.jsp';");
				pWriter.println("</script>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin_gui_page.jsp");
				dispatcher.include(request, response);
			} else {

				// get balance using AdminDbUtils getBalance() and check if balance is
				// insufficient
				double balance = adminDbUtil.getBalance(customerId);

				// check balance is sufficient or not
				if (double_check_amount < balance) {
					// now call getCash() of AdminDbUtil to deduct the balance
					adminDbUtil.getCash(check_amount, customerId, card_number);
					pWriter.println("<script type=\"text/javascript\">");
					pWriter.print("alert('Check Cleared Successfuly');");
					pWriter.println("location='admin_gui_page.jsp';"); // here i need
					pWriter.println("</script>");
					RequestDispatcher dispatcher = request.getRequestDispatcher("admin_gui_page.jsp");
					dispatcher.include(request, response);

					// getEmailUsingSessionCustId
					String email_id = adminDbUtil.getEmailUsingSessionCustId(customerId);

					double withdrawAmount = Double.parseDouble(check_amount);

					// send email after depositing money

					String subject = "Cheque Clear Acknowledgement";
					String content = "<h2 align=\"center\" style=\"color:red\">KARNATAKA BANK</h2><br><h3 align=\"center\">Cheque Cleared Successfuly</h3><br><p style=\"margin-left:10px;\">Cheque No. is: "
							+ check_number
							+ "</p><br><p style=\"margin-left:10px;\">You have succsessfuly credited <span>&#8377;</span><b>"
							+ withdrawAmount
							+ "</b></p><br><p style=\"margin-left:10px;\">Your Balance is: <span>&#8377;</span><b>"
							+ balance + "</b></p>";

					try {
						EmailUtility.sendEmail(host, port, user, pass, email_id, subject, content);

					} catch (Exception ex) {
						ex.printStackTrace();
					}

				} else {
					pWriter.println("<script type=\"text/javascript\">");
					pWriter.print("alert('Insufficient Balance');");
					pWriter.println("location='admin_gui_page.jsp';");
					pWriter.println("</script>");
					RequestDispatcher dispatcher = request.getRequestDispatcher("admin_gui_page.jsp");
					dispatcher.include(request, response);
				}

			}

		} else {
			pWriter.println("<script type=\"text/javascript\">");
			pWriter.print("alert('Invalid Customer ID');");
			pWriter.println("location='admin_gui_page.jsp';");
			pWriter.println("</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin_gui_page.jsp");
			dispatcher.include(request, response);
		}

	}

	// for customer_gui_page.jsp View Balance Button
	private void getBalance(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get card number from session
		HttpSession session = request.getSession(false);
		Customer customer = (Customer) session.getAttribute("customer_info");
		int session_customerId = customer.getCustomerId();

		// get balance from admin db util 'getBalance()'
		double balance = adminDbUtil.getBalance(session_customerId);

		// pass this value to the customer_display_balance.jsp
		request.setAttribute("balance", balance);
		RequestDispatcher dispatcher = request.getRequestDispatcher("customer_display_balance.jsp");
		dispatcher.include(request, response);

	}

	// for customer_gui_page.jsp Fast Cash Button
	private void fastCash(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get amount from customer_withdraw_get_cash.jsp
		String amount = null;
		if (request.getParameter("500") != null) {
			amount = request.getParameter("500");
		} else if (request.getParameter("1000") != null) {
			amount = request.getParameter("1000");
		} else if (request.getParameter("2000") != null) {
			amount = request.getParameter("2000");
		} else if (request.getParameter("5000") != null) {
			amount = request.getParameter("5000");
		}

		// get card number from session
		HttpSession session = request.getSession(false);
		Customer customer = (Customer) session.getAttribute("customer_info");
		int session_customerId = customer.getCustomerId();
		int session_card_no = customer.getCard_no();

		// perform updation in AdminDbUtil by passing amount and card number
		boolean flag = adminDbUtil.fastCash(amount, session_card_no, session_customerId);

		if (flag == false) {
			// send them to customer_withdraw_get_cash.jsp
			PrintWriter pWriter = response.getWriter();
			pWriter.println("<script type=\"text/javascript\">");
			pWriter.println("alert('Cash Withdrawn Successfuly!!!');");
			pWriter.println("location='customer_gui_page.jsp';"); // here i need to add default advertise page
			pWriter.println("</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("customer_gui_page.jsp"); // here i
																									// need to
			dispatcher.include(request, response);

			// getEmailUsingSessionCustId
			String email_id = adminDbUtil.getEmailUsingSessionCustId(session_customerId);

			double balance = adminDbUtil.getBalance(session_customerId);
			double withdrawAmount = Double.parseDouble(amount);

			// send email after depositing money

			String subject = "Withdraw Money Acknowledgement";
			String content = "<h2 align=\"center\" style=\"color:red\">KARNATAKA BANK</h2><br><p style=\"margin-left:10px;\">You have succsessfuly credited <span>&#8377;</span><b>"
					+ withdrawAmount
					+ "</b> by Fast Cash.</p><br><p style=\"margin-left:10px;\">Your Balance is: <span>&#8377;</span><b>"
					+ balance + "</b></p>";

			try {
				EmailUtility.sendEmail(host, port, user, pass, email_id, subject, content);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} else {
			PrintWriter pWriter = response.getWriter();
			pWriter.println("<script type=\"text/javascript\">");
			pWriter.println("alert('Insufficient Balance');");
			pWriter.println("location='customer_gui_page.jsp';"); // here i need to add default advertise page
			pWriter.println("</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("customer_gui_page.jsp"); // here i
																									// need to
			dispatcher.include(request, response);
		}

	}

	// for customer_gui_page.jsp Get Cash Button
	private void getCash(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get amount from customer_withdraw_get_cash.jsp
		String amount = request.getParameter("get_cash");

		// get card number from session
		HttpSession session = request.getSession(false);
		Customer customer = (Customer) session.getAttribute("customer_info");
		int session_customer_id = customer.getCustomerId();
		int session_card_no = customer.getCard_no();

		// perform updation in AdminDbUtil by passing amount and card number
		boolean flag = adminDbUtil.getCash(amount, session_customer_id, session_card_no);

		if (flag == false) {
			// send them to customer_withdraw_get_cash.jsp
			PrintWriter pWriter = response.getWriter();
			pWriter.println("<script type=\"text/javascript\">");
			pWriter.println("alert('Cash Withdrawn Successfuly!!!');");
			pWriter.println("location='customer_gui_page.jsp';"); // here i need to add default advertise page
			pWriter.println("</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("customer_gui_page.jsp"); // here i
																									// need to
			dispatcher.include(request, response);

			// getEmailUsingSessionCustId
			String email_id = adminDbUtil.getEmailUsingSessionCustId(session_customer_id);

			double balance = adminDbUtil.getBalance(session_customer_id);
			double withdrawAmount = Double.parseDouble(amount);

			// send email after depositing money

			String subject = "Withdraw Money Acknowledgement";
			String content = "<h2 align=\"center\" style=\"color:red\">KARNATAKA BANK</h2><br><p style=\"margin-left:10px;\">You have succsessfuly credited <span>&#8377;</span><b>"
					+ withdrawAmount
					+ "</b></p><br><p style=\"margin-left:10px;\">Your Balance is: <span>&#8377;</span><b>" + balance
					+ "</b></p>";

			try {
				EmailUtility.sendEmail(host, port, user, pass, email_id, subject, content);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} else {
			PrintWriter pWriter = response.getWriter();
			pWriter.println("<script type=\"text/javascript\">");
			pWriter.println("alert('Insufficient Balance');");
			pWriter.println("location='customer_gui_page.jsp';"); // here i need to add default advertise page
			pWriter.println("</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("customer_gui_page.jsp"); // here i
																									// need to
			dispatcher.include(request, response);
		}

	}

	// for customer_gui_page.jsp Deposit Button
	private void depositMoney(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get amount from customer_deposit_page.jsp
		String amount = request.getParameter("deposit_amount");

		// get card number from session
		HttpSession session = request.getSession(false);
		Customer customer = (Customer) session.getAttribute("customer_info");
		int session_customerId = customer.getCustomerId();
		int session_card_no = customer.getCard_no();

		// perform updation in AdminDbUtil by passing amount and card number
		adminDbUtil.depositMoney(amount, session_card_no, session_customerId);

		PrintWriter pWriter = response.getWriter();
		pWriter.println("<script type=\"text/javascript\">");
		pWriter.println("alert('Deposited Successfuly!!!');");
		pWriter.println("location='customer_gui_page.jsp';"); // here i need to add default advertise page
		pWriter.println("</script>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("customer_gui_page.jsp"); // here i need to
		dispatcher.include(request, response);

		// getEmailUsingSessionCustId
		String email_id = adminDbUtil.getEmailUsingSessionCustId(session_customerId);

		double depositeAmount = Double.parseDouble(amount);
		double balance = adminDbUtil.getBalance(session_customerId);

		// send email after depositing money

		String subject = "Deposite Money Acknowledgement";
		String content = "<h2 align=\"center\" style=\"color:red\">KARNATAKA BANK</h2><br><p style=\"margin-left:10px;\">You have succsessfuly deposited <span>&#8377;</span><b>"
				+ depositeAmount + "</b></p><br><p style=\"margin-left:10px;\">Your Balance is: <span>&#8377;</span><b>"
				+ balance + "</b></p>";

		try {
			EmailUtility.sendEmail(host, port, user, pass, email_id, subject, content);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	// for customer_gui_page.jsp Change PIN button
	private void changeCustomerPin(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read parameters from customer_pin_change.jsp
		int old_pin = Integer.parseInt(request.getParameter("old_pin"));
		String new_pin = request.getParameter("new_pin");

		// get card_number and pin from session
		HttpSession session = request.getSession(false);
		Customer customer = (Customer) session.getAttribute("customer_info");

		int old_session_pin = customer.getPin();
		int session_card_no = customer.getCard_no();

		// check if session pin and pin from form is same or not

		if (old_pin == old_session_pin) {
			adminDbUtil.changeCustomerPin(new_pin, session_card_no);
			// after change send back to customer_gui_page.jsp

			PrintWriter pWriter = response.getWriter();
			pWriter.println("<script type=\"text/javascript\">");
			pWriter.println("alert('PIN Changed Successfuly!!!');");
			pWriter.println("location='customer_gui_page.jsp';"); // here i need to add default advertise page
			pWriter.println("</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("customer_gui_page.jsp"); // here i need to
			dispatcher.include(request, response);

		} else {
			PrintWriter pWriter = response.getWriter();
			pWriter.println("<script type=\"text/javascript\">");
			pWriter.println("alert('Incorrect Old PIN, Please Enter Valid PIN Number!');");
			pWriter.println("location='customer_gui_page.jsp';");
			pWriter.println("</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("customer_gui_page.jsp");
			dispatcher.include(request, response);
		}

	}

	// for customer_login_form.jsp
	private void verifyCustomers(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// first get Customer from db util
		List<Customer> customers = adminDbUtil.validateCustomers();

		// get parameters from customer_login_form.jsp
		int card_no = Integer.parseInt(request.getParameter("card_no"));
		int pin = Integer.parseInt(request.getParameter("pin_no"));

		boolean flag = false;
		// extract Customer objects from list
		for (Customer customer : customers) {

			// perform validation
			if (card_no == customer.getCard_no() && pin == customer.getPin()) {
				HttpSession session = request.getSession();
				session.setAttribute("customer_info", customer);
				RequestDispatcher dispatcher = request.getRequestDispatcher("customer_gui_page.jsp");
				dispatcher.forward(request, response);
			} else {
				flag = true;

			}
		}
		if (flag == true) {

			// response.sendRedirect("index.html");
			PrintWriter pWriter = response.getWriter();
			pWriter.println("<script type=\"text/javascript\">");
			pWriter.println("alert('Invalid Card No or PIN');");
			pWriter.println("location='index.html';"); // here i need to add default advertise page
			pWriter.println("</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html"); // here i need to add default
																						// advertise page
			dispatcher.include(request, response);
		}

	}

	// for admin_gui_page.jsp Delete Customer button
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get customerId from delete)customer_detail.jsp
		String theCustomerId = request.getParameter("customerId");
		int intCustomerId = Integer.parseInt(theCustomerId);
		boolean flag = false;

		// get customerId from db using List<Customer> getCustomers()
		List<Customer> customers = adminDbUtil.getCustomers();

		// check for duplicate values
		for (Customer customer : customers) {

			if (intCustomerId == customer.getCustomerId()) {
				flag = true;
				break;
			}
		}

		if (flag == true) {
			// delete customer from db
			adminDbUtil.deleteCustomer(theCustomerId);

			// send back to list_customer.jsp
			listCustomer(request, response);
		} else {
			// pWriter.println("Branch Already Exist");
			PrintWriter pWriter = response.getWriter();
			pWriter.println("<script type=\"text/javascript\">");
			pWriter.println("alert('This Customer Not Exist');");
			pWriter.println("location='admin_gui_page.jsp';");
			pWriter.println("</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin_gui_page.jsp");
			dispatcher.include(request, response);
		}

	}

	// for admin_gui_page.jsp Modify Customer button
	private void modifyCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read customer details from modify_customer_account.jsp
		int acc_no = Integer.parseInt(request.getParameter("account_no"));
		String full_name = request.getParameter("full_name");
		String fathers_name = request.getParameter("fathers_name");
		Date dob = Date.valueOf(request.getParameter("dob"));

		String permanent_address = request.getParameter("permanent_address");
		String present_address = request.getParameter("present_address");
		String pan_number = request.getParameter("pan_number");
		long mobile_number = Long.parseLong(request.getParameter("mobile_number"));
		long landline = Long.parseLong(request.getParameter("landline"));
		String account_type = request.getParameter("account_type");
		String check_book = request.getParameter("check_book");

		// create Customer object
		Customer theCustomer = new Customer(acc_no, full_name, fathers_name, dob, permanent_address, present_address,
				pan_number, mobile_number, landline, account_type, check_book);

		// perform update on database
		adminDbUtil.updateCustomer(theCustomer);

		// send them back to the "list_customer.jsp" page
		listCustomer(request, response);

	}

	// to display customer after adding customer by admin
	private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get customers from db util
		List<Customer> customers = adminDbUtil.getCustomers();

		// add customers to the request
		request.setAttribute("CUSTOMER_LIST", customers);

		// send to JSP page list_customer.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("list_customer.jsp");
		dispatcher.forward(request, response);

	}

	// for admin_gui_page.jsp Create Customer button

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read customer details from create_customer_account.jsp
		String full_name = request.getParameter("full_name");
		String fathers_name = request.getParameter("fathers_name");
		String email_id = request.getParameter("email_id");
		Date dob = Date.valueOf(request.getParameter("dob"));
		String gender = request.getParameter("gender");
		String permanent_address = request.getParameter("permanent_address");
		String presnt_address = request.getParameter("present_address");
		String pan_number = request.getParameter("pan_number");
		long mobile_number = Long.parseLong(request.getParameter("mobile_number"));
		long landline = Long.parseLong(request.getParameter("landline"));
		String account_type = request.getParameter("account_type");
		String check_book = request.getParameter("check_book");

		/*
		 * // Generate random integers in range 0 to 9999 for pin int pin =
		 * ThreadLocalRandom.current().nextInt(1, 10000); System.out.println(pin);
		 * 
		 * // Generate random integers in range 0 to 9999999999 for card_no int card_no
		 * = ThreadLocalRandom.current().nextInt(1, 100000000);
		 * System.out.println(card_no);
		 */

		// create new Customer object
		Customer thCustomer = new Customer(full_name, fathers_name, email_id, (java.sql.Date) dob, gender,
				permanent_address, presnt_address, pan_number, mobile_number, landline, account_type, check_book);

		// add the Customer to database
		adminDbUtil.addCustomer(thCustomer);

		// send back again to create_customer_account.jsp
		// response.sendRedirect("create_customer_account.jsp");

		// send them to 'list_customer.jsp' page
		listCustomer(request, response);

		// format date to print in mail
		java.util.Date date = (java.util.Date) new java.util.Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);

		// get acc_no using email id to print acc_no in mail
		int acc_no = adminDbUtil.getAccNoUsingEmail(email_id);

		// send email after adding user
		// reads form fields
		/* String recipient = request.getParameter(recipient); */
		String subject = "Account Opening Acknowledgement";
		String content = "<div style=\"margin-left:auto; margin-right:auto; width: 70%; border: 5px solid brown\"><h2 align=\"center\" style=\"color:red\">KARNATAKA BANK</h2><br><p style=\"margin-left:10px;\">"
				+ strDate + "</p><br><p style=\"margin-left:10px;\">" + full_name
				+ "</p><br><p style=\"margin-left:10px;\"><b>Subject: Confirmation of Your Bank Account No. [" + acc_no
				+ "]</b></p><br><p style=\"margin-left:10px;\">Dear " + full_name
				+ ",</p><br><p style=\"margin-left:10px;\">We are pleased to inform you that your new Account No. ["
				+ acc_no + "] (" + account_type
				+ ") is ready for transaction now. We assure you of our unique services and also inform you that Mobile and Internet Banking will be free for you so you can register for these free services anytime. Please collect your checkbook and ATM Card from your bank Branch within the next five working days.</p><br><p style=\"margin-left:10px;\">Yours Truly,</p><br><p style=\"margin-left:10px;\">Suraj Dalvi,</p><br><p style=\"margin-left:10px;\">KARNATAKA BANK</p></div>";

		// String resultMessage = "";

		try {
			EmailUtility.sendEmail(host, port, user, pass, email_id, subject, content);
			// resultMessage = "The e-mail was sent successfully";
		} catch (Exception ex) {
			ex.printStackTrace();
			// resultMessage = "There were an error: " + ex.getMessage();
		} /*
			 * finally { request.setAttribute("Message", resultMessage);
			 * getServletContext().getRequestDispatcher("/Result.jsp").forward(request,
			 * response); }
			 */

	}

	// for admin_gui_page.jsp Add Branch button
	private void addBranch(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read branch info from form data
		String branch_name = request.getParameter("branch_name").toLowerCase().trim();
		String branch_state = request.getParameter("branch_state").toLowerCase().trim();
		PrintWriter pWriter = response.getWriter();
		boolean flag = false;

		// create a new branch object
		Branch theBranch = new Branch(branch_name, branch_state);

		// check for duplicate values
		// first get all branch names
		List<Branch> branches = adminDbUtil.getBranches();

		// check if initially branch names are null
		if (branches.isEmpty()) {
			// add the branch to database
			adminDbUtil.addBranch(theBranch);
		} else {
			// compare with parameter came from request
			for (Branch oneBranch : branches) {
				if (branch_name.equals(oneBranch.getBranch_name().toLowerCase().trim())
						&& branch_state.equals(oneBranch.getBranch_State().toLowerCase().trim())) {
					flag = true;
					break;
				}
			}

			if (flag == false) {

				// add the branch to database
				adminDbUtil.addBranch(theBranch);

				// send back again to admin_gui_page.jsp
				pWriter.println("<script type=\"text/javascript\">");
				pWriter.println("alert('Branch Added Succsessfuly');");
				pWriter.println("location='admin_gui_page.jsp';"); // here i need to add default advertise
																	// page
				pWriter.println("</script>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin_gui_page.jsp"); // here
																									// i
																									// need
																									// to
																									// add
				// default advertise
				// page
				dispatcher.include(request, response);
			} else {
				// pWriter.println("Branch Already Exist");
				pWriter.println("<script type=\"text/javascript\">");
				pWriter.println("alert('This Branch Already Exist');");
				pWriter.println("location='admin_gui_page.jsp';");
				pWriter.println("</script>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin_gui_page.jsp");
				dispatcher.include(request, response);
			}
		}

	}

	// for admin_login_form.jsp
	private void verifyAdmins(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get admins from db util
		List<Admin> admins = adminDbUtil.getAdmins();

		// extract admin objects from list

		/*
		 * Admin data = admins.get(0); String userid = data.getUserid(); String pswd =
		 * data.getPassword();
		 */

		// get parameters from request
		String userId = request.getParameter("userid");
		String password = request.getParameter("password");

		boolean flag = false;
		for (Admin admin : admins) {
			// perform validation
			if (userId.equals(admin.getUserid()) && password.equals(admin.getPassword())) {
				flag = false;
				HttpSession session = request.getSession();
				session.setAttribute("admin_info", admin);
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin_gui_page.jsp");
				dispatcher.forward(request, response);
				break;

			} else {
				flag = true;
			}

		}
		if (flag == true) {

			PrintWriter pWriter = response.getWriter();
			pWriter.println("<script type=\"text/javascript\">");
			pWriter.println("alert('Invalid UserID or Password');");
			pWriter.println("location='index.html';");
			pWriter.println("</script>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);
		}
	}

}
