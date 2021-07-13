package com.ssd;

import java.sql.Date;

public class Transactions {

	private int card_no;
	private Date transaction_date;
	private String transaction_amount;

	public Transactions(int card_no, Date transaction_date, String transaction_amount) {

		this.card_no = card_no;
		this.transaction_date = transaction_date;
		this.transaction_amount = transaction_amount;
	}

	public int getCard_no() {
		return card_no;
	}

	public void setCard_no(int card_no) {
		this.card_no = card_no;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

	public String getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(String transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

}
