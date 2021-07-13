package com.ssd;

public class Branch {
	private String branch_name;
	private String branch_state;

	public Branch(String branch_name, String branch_state) {

		this.branch_name = branch_name;
		this.branch_state = branch_state;
	}

	// this constructor is for checking duplicate branch_name
	public Branch(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getBranch_State() {
		return branch_state;
	}

	public void setBranch_State(String branch_state) {
		this.branch_state = branch_state;
	}

}
