package com.ssd;

public class Customer {

	private String full_name;
	private String fathers_name;
	private String email_id;
	private java.sql.Date dob;
	private String gender;
	private String permanent_address;
	private String present_address;
	private String pan_number;
	private long mobile_number;
	private long landline;
	private String account_type;
	private double openning_balance;
	private int customerId;
	private int acc_no;
	private int card_no;
	private int pin;
	private String check_book;
	private double balance;

	// constructor to create customer
	public Customer(String full_name, String fathers_name, String email_id, java.sql.Date dob, String gender,
			String permanent_address, String present_address, String pan_number, long mobile_number, long landline,
			String account_type, String check_book) {

		this.full_name = full_name;
		this.fathers_name = fathers_name;
		this.email_id = email_id;
		this.dob = dob;
		this.gender = gender;
		this.permanent_address = permanent_address;
		this.present_address = present_address;
		this.pan_number = pan_number;
		this.mobile_number = mobile_number;
		this.landline = landline;
		this.account_type = account_type;
		this.check_book = check_book;
	}

	public Customer(String full_name, String fathers_name, java.sql.Date dob, String gender, String permanent_address,
			String present_address, String pan_number, long mobile_number, long landline, String account_type,
			double openning_balance, int customerId, String check_book) {

		this.full_name = full_name;
		this.fathers_name = fathers_name;
		this.dob = dob;
		this.gender = gender;
		this.permanent_address = permanent_address;
		this.present_address = present_address;
		this.pan_number = pan_number;
		this.mobile_number = mobile_number;
		this.landline = landline;
		this.account_type = account_type;
		this.openning_balance = openning_balance;
		this.customerId = customerId;
		this.check_book = check_book;
	}

	public Customer(String full_name, String fathers_name, java.sql.Date dob, String gender, String permanent_address,
			String present_address, String pan_number, long mobile_number, long landline, String account_type,
			int customerId, String check_book) {

		this.full_name = full_name;
		this.fathers_name = fathers_name;
		this.dob = dob;
		this.gender = gender;
		this.permanent_address = permanent_address;
		this.present_address = present_address;
		this.pan_number = pan_number;
		this.mobile_number = mobile_number;
		this.landline = landline;
		this.account_type = account_type;
		this.customerId = customerId;
		this.check_book = check_book;
	}

	public Customer(String full_name, String fathers_name, java.sql.Date dob, String gender, String permanent_address,
			String present_address, String pan_number, long mobile_number, long landline, String account_type,
			double openning_balance, int customerId, int acc_no, int card_no, int pin, String check_book) {

		this.full_name = full_name;
		this.fathers_name = fathers_name;
		this.dob = dob;
		this.gender = gender;
		this.permanent_address = permanent_address;
		this.present_address = present_address;
		this.pan_number = pan_number;
		this.mobile_number = mobile_number;
		this.landline = landline;
		this.account_type = account_type;
		this.openning_balance = openning_balance;
		this.customerId = customerId;
		this.acc_no = acc_no;
		this.card_no = card_no;
		this.pin = pin;
		this.check_book = check_book;
	}

	public Customer(int acc_no, String full_name, String fathers_name, java.sql.Date dob, String permanent_address,
			String present_address, String pan_number, long mobile_number, long landline, String account_type,
			String check_book) {

		this.acc_no = acc_no;
		this.full_name = full_name;
		this.fathers_name = fathers_name;
		this.dob = dob;
		this.permanent_address = permanent_address;
		this.present_address = present_address;
		this.pan_number = pan_number;
		this.mobile_number = mobile_number;
		this.landline = landline;
		this.account_type = account_type;
		this.check_book = check_book;
	}

	public Customer(String full_name, String fathers_name, java.sql.Date dob, String gender, String permanent_address,
			String present_address, String pan_number, long mobile_number, long landline, String account_type,
			double openning_balance, int customerId, int acc_no, int card_no, String check_book) {

		this.full_name = full_name;
		this.fathers_name = fathers_name;
		this.dob = dob;
		this.gender = gender;
		this.permanent_address = permanent_address;
		this.present_address = present_address;
		this.pan_number = pan_number;
		this.mobile_number = mobile_number;
		this.landline = landline;
		this.account_type = account_type;
		this.openning_balance = openning_balance;
		this.customerId = customerId;
		this.acc_no = acc_no;
		this.card_no = card_no;
		this.check_book = check_book;
	}

	public Customer(String full_name, String fathers_name, String email_id, java.sql.Date dob, String gender,
			String permanent_address, String present_address, String pan_number, long mobile_number, long landline,
			String account_type, double openning_balance, int customerId, int acc_no, int card_no, String check_book) {

		this.full_name = full_name;
		this.fathers_name = fathers_name;
		this.email_id = email_id;
		this.dob = dob;
		this.gender = gender;
		this.permanent_address = permanent_address;
		this.present_address = present_address;
		this.pan_number = pan_number;
		this.mobile_number = mobile_number;
		this.landline = landline;
		this.account_type = account_type;
		this.openning_balance = openning_balance;
		this.customerId = customerId;
		this.acc_no = acc_no;
		this.card_no = card_no;
		this.check_book = check_book;
	}

	public Customer(int card_no, int pin) {
		this.card_no = card_no;
		this.pin = pin;
	}

	public Customer(int customerId, int card_no, int pin) {
		this.customerId = customerId;
		this.card_no = card_no;
		this.pin = pin;
	}

	public Customer(double balance) {
		this.balance = balance;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getFathers_name() {
		return fathers_name;
	}

	public void setFathers_name(String fathers_name) {
		this.fathers_name = fathers_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public java.sql.Date getDob() {
		return dob;
	}

	public void setDob(java.sql.Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPermanent_address() {
		return permanent_address;
	}

	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}

	public String getPresent_address() {
		return present_address;
	}

	public void setPresent_address(String present_address) {
		this.present_address = present_address;
	}

	public String getPan_number() {
		return pan_number;
	}

	public void setPan_number(String pan_number) {
		this.pan_number = pan_number;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public long getLandline() {
		return landline;
	}

	public void setLandline(long landline) {
		this.landline = landline;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public double getOpenning_balance() {
		return openning_balance;
	}

	public void setOpenning_balance(double openning_balance) {
		this.openning_balance = openning_balance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public int getCard_no() {
		return card_no;
	}

	public void setCard_no(int card_no) {
		this.card_no = card_no;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getCheck_book() {
		return check_book;
	}

	public void setCheck_book(String check_book) {
		this.check_book = check_book;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
