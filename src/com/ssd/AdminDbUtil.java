package com.ssd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class AdminDbUtil {

	private DataSource dataSource;

	// Admin_Validation_Servlet will provide reference of data source object to this
	// constructor
	public AdminDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	// method to list the admins for verification
	public List<Admin> getAdmins() throws Exception {

		List<Admin> admins = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// define driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get a connection
			// myConn = DriverManager.getConnection("
			// jdbc:mysql://localhost:3307/automatedtellermachine");
			myConn = dataSource.getConnection();

			// create sql statement
			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery("select * from logincredentials");

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				String userid = myRs.getString("userid");
				String password = myRs.getString("password");

				// create new admin object
				Admin tempAdmin = new Admin(userid, password);

				// add it to the list of admins
				admins.add(tempAdmin);
			}

			return admins;

		} finally {
			// close JDBC connection
			close(myConn, myStmt, myRs);
		}

	}

	// helper method for all methods
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myStmt != null) {
				myStmt.close();
			} else if (myRs != null) {
				myRs.close();
			} else if (myConn != null) {
				myConn.close(); // doesn't really close it...just puts back in connection pool
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addBranch(Branch theBranch) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create sql for insert
			String sql = "insert into branchdetails (BranchName, State) values (?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set the param values for the Branch
			myStmt.setString(1, theBranch.getBranch_name());
			myStmt.setString(2, theBranch.getBranch_State());

			// execute sql insert
			myStmt.execute();

		} finally {

			// clean up JDBC objects
			close(myConn, myStmt, null);
		}

	}

	public List<Branch> getBranches() throws Exception {
		List<Branch> branch_names = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// define driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get a connection
			myConn = dataSource.getConnection();

			// create sql statement
			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery("select BranchName, State from branchdetails");

			// process resultset
			while (myRs.next()) {

				// retrieve data from result set row
				String branch_name = myRs.getString("BranchName");
				String state = myRs.getString("State");

				// create new branch object
				Branch tempBranch = new Branch(branch_name, state);

				// add it to the list of branch_names
				branch_names.add(tempBranch);

			}

			return branch_names;

		} finally {
			// cleanup JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void addCustomer(Customer theCustomer) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		int accNo = (int) (Math.random() * 10000000);
		int cardNo = (int) (Math.random() * 1000000);
		int pin = (int) (Math.random() * 10000);

		try {
			// define driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get db connection
			myConn = dataSource.getConnection();

			// create sql for insert
			String sql = "insert into customer_account_details (Full_Name, Fathers_Name, EmailID, DOB, Gender, Permanent_Address, Present_Address, PAN_Number, Mobile_Number, Landline, Account_Type, AccNo, CardNo, PIN, CheckBook) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set the param values for the Branch
			myStmt.setString(1, theCustomer.getFull_name());
			myStmt.setString(2, theCustomer.getFathers_name());
			myStmt.setString(3, theCustomer.getEmail_id());
			myStmt.setDate(4, theCustomer.getDob());
			myStmt.setString(5, theCustomer.getGender());
			myStmt.setString(6, theCustomer.getPermanent_address());
			myStmt.setString(7, theCustomer.getPresent_address());
			myStmt.setString(8, theCustomer.getPan_number());
			myStmt.setLong(9, theCustomer.getMobile_number());
			myStmt.setLong(10, theCustomer.getLandline());
			myStmt.setString(11, theCustomer.getAccount_type());
			myStmt.setInt(12, accNo);
			myStmt.setInt(13, cardNo);
			myStmt.setInt(14, pin);
			myStmt.setString(15, theCustomer.getCheck_book());

			// execute sql insert
			myStmt.execute();

		} finally {

			// clean up JDBC objects
			close(myConn, myStmt, null);
		}

	}

	public List<Customer> getCustomers() throws Exception {
		List<Customer> customers = new ArrayList<Customer>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// define driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get connection
			myConn = dataSource.getConnection();

			// create sql statement
			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery("select * from customer_account_details");

			// process result set
			while (myRs.next()) {
				// retrieve data from resultset
				String full_name = myRs.getString("Full_Name");
				String fathers_name = myRs.getString("Fathers_Name");
				String email_id = myRs.getString("EmailID");
				Date dob = myRs.getDate("DOB");
				String gender = myRs.getString("Gender");
				String permanent_address = myRs.getString("Permanent_Address");
				String present_address = myRs.getString("Present_Address");
				String pan_number = myRs.getString("PAN_Number");
				long mobile_number = myRs.getLong("Mobile_Number");
				long landline = myRs.getLong("Landline");
				String account_type = myRs.getString("Account_Type");
				double openning_balance = myRs.getDouble("Openning_Balance");
				int customerId = myRs.getInt("CustomerID");
				int acc_no = myRs.getInt("AccNo");
				int card_no = myRs.getInt("CardNo");

				String check_book = myRs.getString("CheckBook");

				// create Customer object
				Customer tempCustomer = new Customer(full_name, fathers_name, email_id, dob, gender, permanent_address,
						present_address, pan_number, mobile_number, landline, account_type, openning_balance,
						customerId, acc_no, card_no, check_book);

				// add the tempCustomer object to the list
				customers.add(tempCustomer);
			}

			return customers;
		} finally {
			close(myConn, myStmt, myRs);
		}

	}

	public Customer getCustomers(String theCustomerId) throws Exception {

		Customer theCustomer = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int customerIds;

		try {
			customerIds = Integer.parseInt(theCustomerId);

			// define driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get connection to database
			myConn = dataSource.getConnection();

			// create sql to get selected student
			String sql = "select * from customer_account_details where id=?";

			// create prepared statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, customerIds);

			// execute statement
			myRs = myStmt.executeQuery();

			// retrieve data from result set row
			if (myRs.next()) {
				String full_name = myRs.getString("Full_Name");
				String fathers_name = myRs.getString("Fathers_Name");
				Date dob = myRs.getDate("DOB");
				String gender = myRs.getString("Gender");
				String permanent_address = myRs.getString("Permanent_Address");
				String present_address = myRs.getString("Present_Address");
				String pan_number = myRs.getString("PAN_Number");
				long mobile_number = myRs.getLong("Mobile_Number");
				long landline = myRs.getLong("Landline");
				String account_type = myRs.getString("Account_Type");
				double openning_balance = myRs.getDouble("Openning_Balance");
				int customerId = myRs.getInt("CustomerID");
				String check_book = myRs.getString("CheckBook");

				theCustomer = new Customer(full_name, fathers_name, dob, gender, permanent_address, present_address,
						pan_number, mobile_number, landline, account_type, openning_balance, customerId, check_book);
			} else {
				throw new Exception("Could not find Customer id: " + customerIds);
			}

			return theCustomer;

		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);

		}

	}

	public Customer getCustomerUsingAccNo(int acc_no) throws Exception {

		Customer theCustomer = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// define driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get connection to database
			myConn = dataSource.getConnection();

			// create sql to get selected student
			String sql = "select * from customer_account_details where AccNo=?";

			// create prepared statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, acc_no);

			// execute statement
			myRs = myStmt.executeQuery();

			// retrieve data from result set row
			if (myRs.next()) {

				String full_name = myRs.getString("Full_Name");
				String fathers_name = myRs.getString("Fathers_Name");
				Date dob = myRs.getDate("DOB");

				String permanent_address = myRs.getString("Permanent_Address");
				String present_address = myRs.getString("Present_Address");
				String pan_number = myRs.getString("PAN_Number");
				long mobile_number = myRs.getLong("Mobile_Number");
				long landline = myRs.getLong("Landline");
				String account_type = myRs.getString("Account_Type");

				String check_book = myRs.getString("CheckBook");

				theCustomer = new Customer(acc_no, full_name, fathers_name, dob, permanent_address, present_address,
						pan_number, mobile_number, landline, account_type, check_book);
			} else {
				throw new Exception("Could not find Customer id: " + acc_no);
			}

			return theCustomer;

		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);

		}

	}

	public void updateCustomer(Customer theCustomer) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get DB connection
			myConn = dataSource.getConnection();

			// create sql update statement
			String sql = "update customer_account_details set Full_Name=?, Fathers_Name=?, DOB=?, Permanent_Address=?, Present_Address=?, PAN_Number=?, Mobile_Number=?, Landline=?, Account_Type=?, CheckBook=? where AccNo=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params to sql query
			myStmt.setString(1, theCustomer.getFull_name());
			myStmt.setString(2, theCustomer.getFathers_name());
			myStmt.setDate(3, theCustomer.getDob());

			myStmt.setString(4, theCustomer.getPermanent_address());
			myStmt.setString(5, theCustomer.getPresent_address());
			myStmt.setString(6, theCustomer.getPan_number());
			myStmt.setLong(7, theCustomer.getMobile_number());
			myStmt.setLong(8, theCustomer.getLandline());
			myStmt.setString(9, theCustomer.getAccount_type());

			myStmt.setString(10, theCustomer.getCheck_book());
			myStmt.setInt(11, theCustomer.getAcc_no());

			// execute sql statement
			myStmt.execute();

		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}

	}

	public void deleteCustomer(String theCustomerId) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// convert customerId to int
			int customerId = Integer.parseInt(theCustomerId);

			// get connection to db
			myConn = dataSource.getConnection();

			// cretae sql to delete customer
			String sqlString = "delete from customer_account_details where CustomerID=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sqlString);

			// set params
			myStmt.setInt(1, customerId);

			// execute sql statement
			myStmt.execute();

		} finally {
			// clean up JDBC obj
			close(myConn, myStmt, null);
		}

	}

	public List<Customer> validateCustomers() throws Exception {

		List<Customer> customer = new ArrayList<Customer>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// define driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get a connection
			myConn = dataSource.getConnection();

			// create sql statement
			myStmt = myConn.createStatement();

			// execute query
			myRs = myStmt.executeQuery("select CustomerID, CardNo, PIN from customer_account_details");

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int customerId = myRs.getInt("CustomerID");
				int card_no = myRs.getInt("CardNo");
				int pin = myRs.getInt("PIN");

				// create new admin object
				Customer tempCustomer = new Customer(customerId, card_no, pin);

				// add it to the list of admins
				customer.add(tempCustomer);

			}

			return customer;
		} finally {
			// clean up operation
			close(myConn, myStmt, myRs);
		}
	}

	public void changeCustomerPin(String new_pin, int session_card_no) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		int newpin = Integer.parseInt(new_pin);

		try {
			// get connection
			myConn = dataSource.getConnection();

			// create sql update statement
			String sql = "update customer_account_details set PIN=? where CardNo=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, newpin);
			myStmt.setInt(2, session_card_no);

			// execute statement
			myStmt.execute();

		} finally {
			close(myConn, myStmt, null);
		}

	}

	// changed argument from session_card_no to customerId
	public double getBalance(int customerId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		double balance = 0;

		try {
			// define driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get connection
			myConn = dataSource.getConnection();

			// Get balance from database
			String sql = "select Balance from customer_account_details where CustomerID=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, customerId);

			// execute statement
			myRs = myStmt.executeQuery();

			// extract values from result set
			if (myRs.next()) {
				balance = myRs.getDouble("Balance");

			} else {
				throw new Exception("Invalid CustomerID");
			}

			return balance;

		} finally {
			close(myConn, myStmt, myRs);
		}
	}

	// this method is for storing current date in transactions table
	public Date getCurrentDate() {

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		return date;
	}

	public void depositMoney(String amount, int session_card_no, int session_customerId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		// get balance from getBalance()
		double balance = getBalance(session_customerId);
		double converted_amount = Double.parseDouble(amount);

		// calculate amount
		double final_amount_to_store = balance + converted_amount;

		try {
			// get connection
			myConn = dataSource.getConnection();

			// create sql statement
			String sql = "update customer_account_details set Balance=? where CustomerID=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setDouble(1, final_amount_to_store);
			myStmt.setInt(2, session_customerId);

			// execute statement
			myStmt.execute();

			// close statement object to reuse for following sql query
			myStmt.close();

			// create new insert statement for entry in transactions table
			String sql1 = "insert into transactions (CardNo, Transaction_Date, Transaction_Amount) values (?, ?, ?)";

			// again prepare statement
			myStmt = myConn.prepareStatement(sql1);

			// set params
			myStmt.setInt(1, session_card_no);
			myStmt.setDate(2, getCurrentDate());
			myStmt.setString(3, ("+ " + amount));

			// execute statement
			myStmt.execute();

		} finally {
			close(myConn, myStmt, null);
		}

	}

	public boolean getCash(String amount, int customerId, int session_card_no) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		// get balance from getBalance()
		double balance = getBalance(customerId);
		double converted_amount = Double.parseDouble(amount);

		boolean flag = false;
		// calculate amount
		if (converted_amount < balance) {
			double final_amount_to_store = balance - converted_amount;

			try {
				// get connection
				myConn = dataSource.getConnection();

				// create sql statement
				String sql = "update customer_account_details set Balance=? where CustomerID=?";

				// prepare statement
				myStmt = myConn.prepareStatement(sql);

				// set params
				myStmt.setDouble(1, final_amount_to_store);
				myStmt.setInt(2, customerId);

				// execute statement
				myStmt.execute();

				// close statement object to reuse for following sql query
				myStmt.close();

				// create new insert statement for entry in transactions table
				String sql1 = "insert into transactions (CardNo, Transaction_Date, Transaction_Amount) values (?, ?, ?)";

				// again prepare statement
				myStmt = myConn.prepareStatement(sql1);

				// set params
				myStmt.setInt(1, session_card_no);
				myStmt.setDate(2, getCurrentDate());
				myStmt.setString(3, ("- " + amount));

				// execute statement
				myStmt.execute();

			} finally {

				// clean up JDBC object
				close(myConn, myStmt, null);
			}
		} else {
			// throw new Exception("Insufficient Balance");
			flag = true;
		}

		return flag;

	}

	public boolean fastCash(String amount, int session_card_no, int session_customerId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		// get balance from getBalance()
		double balance = getBalance(session_customerId);
		double converted_amount = Double.parseDouble(amount);

		boolean flag = false;
		// calculate amount
		if (converted_amount < balance) {
			double final_amount_to_store = balance - converted_amount;

			try {
				// get connection
				myConn = dataSource.getConnection();

				// create sql statement
				String sql = "update customer_account_details set Balance=? where CustomerID=?";

				// prepare statement
				myStmt = myConn.prepareStatement(sql);

				// set params
				myStmt.setDouble(1, final_amount_to_store);
				myStmt.setInt(2, session_customerId);

				// execute statement
				myStmt.execute();

				// close statement object to reuse for following sql query
				myStmt.close();

				// create new insert statement for entry in transactions table
				String sql1 = "insert into transactions (CardNo, Transaction_Date, Transaction_Amount) values (?, ?, ?)";

				// again prepare statement
				myStmt = myConn.prepareStatement(sql1);

				// set params
				myStmt.setInt(1, session_card_no);
				myStmt.setDate(2, getCurrentDate());
				myStmt.setString(3, ("- " + amount));

				// execute statement
				myStmt.execute();

			} finally {
				// clean up JDBC object
				close(myConn, myStmt, null);
			}
		} else {
			// throw new Exception("Insufficient Balance");
			flag = true;
		}

		return flag;
	}

	public boolean clearCheck(int customerId, int check_number) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		List<Integer> check_numbers = new ArrayList<Integer>();

		try {

			// get connection to database
			myConn = dataSource.getConnection();

			// create sql to get selected student
			String sql = "select * from check_details where CustomerID=?";

			// create prepared statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, customerId);

			// execute statement
			myRs = myStmt.executeQuery();

			// retrieve data from result set row
			if (myRs.next()) {
				check_numbers.add(myRs.getInt("check_number_1"));
				check_numbers.add(myRs.getInt("check_number_2"));
				check_numbers.add(myRs.getInt("check_number_3"));
				check_numbers.add(myRs.getInt("check_number_4"));
				check_numbers.add(myRs.getInt("check_number_5"));
				check_numbers.add(myRs.getInt("check_number_6"));
				check_numbers.add(myRs.getInt("check_number_7"));
				check_numbers.add(myRs.getInt("check_number_8"));
				check_numbers.add(myRs.getInt("check_number_9"));
				check_numbers.add(myRs.getInt("check_number_10"));
			} else {
				throw new Exception("Check Number is Invalid");
			}

			// check if check_number is present in the list of particular customer and if
			// present call getCash()
			boolean flag = false;
			for (int check_no : check_numbers) {
				if (check_number == check_no) {
					// to credit check call getCash()
					// getCash(checkAmount, customerId, card_number);
					flag = false;
					break;
				} else {
					flag = true;
				}
			}

			return flag;
		} finally {
			close(myConn, myStmt, myRs);
		}
	}

	// helper method for clearCheck() and getTransactionForAccountStatement(int
	// customer_id)
	public int getCardNo(int customerId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int card_no;

		try {
			// get connection
			myConn = dataSource.getConnection();

			// Get balance from database
			String sql = "select CardNo from customer_account_details where CustomerID=?";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, customerId);

			// execute statement
			myRs = myStmt.executeQuery();

			// extract values from result set
			if (myRs.next()) {
				card_no = myRs.getInt("CardNo");

			} else {
				throw new Exception("Invalid CustomerID");
			}

			return card_no;

		} finally {
			close(myConn, myStmt, myRs);
		}

	}

	public List<Transactions> customer_mini_statement(int session_card_no) throws Exception {

		List<Transactions> transactions = new ArrayList<Transactions>();

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// get connection
			myConn = dataSource.getConnection();

			// create sql query
			String sql = "SELECT * FROM transactions where CardNo=? order by Transaction_Date DESC limit 10";

			// prepare statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, session_card_no);

			// excute statement
			myRs = myStmt.executeQuery();

			// extract values and add into Transactions object
			while (myRs.next()) {

				int card_no = myRs.getInt("CardNo");
				Date transaction_date = myRs.getDate("Transaction_Date");
				String transaction_amount = myRs.getString("Transaction_Amount");

				Transactions transaction = new Transactions(card_no, transaction_date, transaction_amount);

				transactions.add(transaction);
			}

			return transactions;
		} finally {
			close(myConn, myStmt, myRs);
		}

	}

	public Customer getCustomerInfo(int customer_id) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		Customer tempCustomer = null;

		try {
			// define driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get connection
			myConn = dataSource.getConnection();

			// create sql string
			String sql = "select * from customer_account_details where CustomerID=?";

			// create sql statement
			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, customer_id);

			// execute query
			myRs = myStmt.executeQuery();

			// process result set
			while (myRs.next()) {
				// retrieve data from resultset
				String full_name = myRs.getString("Full_Name");
				String fathers_name = myRs.getString("Fathers_Name");
				Date dob = myRs.getDate("DOB");
				String gender = myRs.getString("Gender");
				String permanent_address = myRs.getString("Permanent_Address");
				String present_address = myRs.getString("Present_Address");
				String pan_number = myRs.getString("PAN_Number");
				long mobile_number = myRs.getLong("Mobile_Number");
				long landline = myRs.getLong("Landline");
				String account_type = myRs.getString("Account_Type");
				double openning_balance = myRs.getDouble("Openning_Balance");
				int customerId = myRs.getInt("CustomerID");
				int acc_no = myRs.getInt("AccNo");
				int card_no = myRs.getInt("CardNo");

				String check_book = myRs.getString("CheckBook");

				// create Customer object
				tempCustomer = new Customer(full_name, fathers_name, dob, gender, permanent_address, present_address,
						pan_number, mobile_number, landline, account_type, openning_balance, customerId, acc_no,
						card_no, check_book);

			}

			return tempCustomer;
		} finally {
			close(myConn, myStmt, myRs);
		}

	}

	public List<Transactions> getTransactionForAccountStatement(int card_no, String from_date, String to_date)
			throws Exception {

		// define our own method to get transactions from and to date

		List<Transactions> transactions = new ArrayList<Transactions>();

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// define driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get connection
			myConn = dataSource.getConnection();

			// create sql query

			// and Transaction_Date between '2021/02/24' and '2021/02/26'
			// String sql = "select * from transactions where CardNo=? ";

			// prepare statement
			myStmt = myConn
					.prepareStatement("SELECT * FROM transactions where CardNo=? and Transaction_Date between ? and ?");

			// set params
			myStmt.setInt(1, card_no);
			myStmt.setString(2, from_date);
			myStmt.setString(3, to_date);

			// excute statement
			myRs = myStmt.executeQuery();

			// extract values and add into Transactions object
			while (myRs.next()) {

				int card_number = myRs.getInt("CardNo");
				Date transaction_date = myRs.getDate("Transaction_Date");
				String transaction_amount = myRs.getString("Transaction_Amount");

				Transactions transaction = new Transactions(card_number, transaction_date, transaction_amount);

				transactions.add(transaction);
			}

			return transactions;
		} finally {
			close(myConn, myStmt, myRs);
		}

	}

	public int getAccNoUsingEmail(String email_id) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int acc_no = 0;

		try {
			// define driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get connection
			myConn = dataSource.getConnection();

			// prepare statement
			myStmt = myConn.prepareStatement("select AccNo from customer_account_details where EmailID = ?");

			// set params
			myStmt.setString(1, email_id);

			// execute statement
			myRs = myStmt.executeQuery();

			// process result set and store into variable
			if (myRs.next()) {
				acc_no = myRs.getInt("AccNo");
			}

			return acc_no;
		} finally {
			close(myConn, myStmt, myRs);
		}

	}

	public String getEmailUsingSessionCustId(int session_customerId) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		String mail_id = "";

		try {
			// define driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// get connection
			myConn = dataSource.getConnection();

			// prepare statement
			myStmt = myConn.prepareStatement("select EmailID from customer_account_details where CustomerID = ?");

			// set params
			myStmt.setInt(1, session_customerId);

			// execute statement
			myRs = myStmt.executeQuery();

			// process result set and store into variable
			if (myRs.next()) {
				mail_id = myRs.getString("EmailID");
			}

			return mail_id;
		} finally {
			close(myConn, myStmt, myRs);
		}
	}

}
