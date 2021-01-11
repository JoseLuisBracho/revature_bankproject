package com.dutybank.model;

import java.util.Date;

public class UserLogIn {
	private int user_id;
	private String email;
	private String password;
	private Date creation_date;
	
	public UserLogIn() {
		// TODO Auto-generated constructor stub
	}

	public UserLogIn(int user_id, String email, String password, Date creation_date) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.password = password;
		this.creation_date = creation_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	@Override
	public String toString() {
		return "UserLogIn [user_id=" + user_id + ", email=" + email + ", password=" + password + ", creation_date=" + creation_date + "]";
	}
	
	

}
