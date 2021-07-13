package com.ssd;

public class Admin {

	private String userid;
	private String password;

	public Admin(String userid, String password) {
		this.userid = userid;
		this.password = password;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// toString() useful for debugging
	@Override
	public String toString() {
		return "Admin [userid=" + userid + ", password=" + password + "]";
	}

}
