package com.dutybank.model;

public class BankUserAccount {
	public int clientid;
	public int accountid;
	
	public BankUserAccount() {
		// TODO Auto-generated constructor stub
	}

	public BankUserAccount(int clientid, int accountid) {
		super();
		this.clientid = clientid;
		this.accountid = accountid;
	}

	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	@Override
	public String toString() {
		return "BankUserAccount [clientid=" + clientid + ", accountid=" + accountid + "]";
	}
	
	

}
