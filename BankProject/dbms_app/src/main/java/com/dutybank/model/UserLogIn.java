package com.dutybank.model;

import java.util.Date;

public class UserLogIn {
	private int login_id;
	private String email;
	private String password;
	private Date creation_date;
	private String user_type;
	
	public UserLogIn() {
		// TODO Auto-generated constructor stub
	}

	public UserLogIn(int login_id, String email, String password, Date creation_date, String user_type) {
		super();
		this.login_id = login_id;
		this.email = email;
		this.password = password;
		this.creation_date = creation_date;
		this.setUser_type(user_type);
	}
	
	public UserLogIn(String email, String password, Date creation_date, String user_type) {
		super();
		this.email = email;
		this.password = password;
		this.creation_date = creation_date;
		this.setUser_type(user_type);
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	@Override
	public String toString() {
		return "UserLogIn [login_id=" + login_id + ", email=" + email + ", password=" + password + ", creation_date="
				+ creation_date + ", user_type=" + user_type + "]";
	}
	
	

}
