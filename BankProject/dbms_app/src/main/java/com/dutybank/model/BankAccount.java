package com.dutybank.model;

import java.util.Date;

public class BankAccount {
	private int accountid;
	private String accounttype;
	private int clientid;
	private double accountbalance;
	private double accountrate;
	private Date accountopen;
	private boolean accountactive;
	
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

	public BankAccount(int accountid, String accounttype, int clientid, double accountbalance, double accountrate,
			Date accountopen, boolean accountactive) {
		super();
		this.accountid = accountid;
		this.accounttype = accounttype;
		this.clientid = clientid;
		this.accountbalance = accountbalance;
		this.accountrate = accountrate;
		this.accountopen = accountopen;
		this.accountactive = accountactive;
	}
	
	public BankAccount(String accounttype, int clientid, double accountbalance, double accountrate,
			Date accountopen, boolean accountactive) {
		super();
		this.accounttype = accounttype;
		this.clientid = clientid;
		this.accountbalance = accountbalance;
		this.accountrate = accountrate;
		this.accountopen = accountopen;
		this.accountactive = accountactive;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	public double getAccountbalance() {
		return accountbalance;
	}

	public void setAccountbalance(double accountbalance) {
		this.accountbalance = accountbalance;
	}

	public double getAccountrate() {
		return accountrate;
	}

	public void setAccountrate(double accountrate) {
		this.accountrate = accountrate;
	}

	public Date getAccountopen() {
		return accountopen;
	}

	public void setAccountopen(Date accountopen) {
		this.accountopen = accountopen;
	}


	public boolean isAccountactive() {
		return accountactive;
	}

	public void setAccountactive(boolean accountactive) {
		this.accountactive = accountactive;
	}

	@Override
	public String toString() {
		return "BankAccount [accountid=" + accountid + ", accounttype=" + accounttype + ", clientid=" + clientid
				+ ", accountbalance=" + accountbalance + ", accountrate=" + accountrate + ", accountopen=" + accountopen
				+ ", accountactive=" + accountactive + "]";
	}
	
	

}
