package com.dutybank.model;

import java.util.Date;

public class BankTransaction {
	private int transactionid;
	private int accountid;
	private String transactiontype;
	private double transactionamount;
	private Date transactiondate;
	
	public BankTransaction() {
		// TODO Auto-generated constructor stub
	}

	public BankTransaction(int transactionid, int accountid, String transactiontype, double transactionamount,
			Date transactiondate) {
		super();
		this.transactionid = transactionid;
		this.accountid = accountid;
		this.transactiontype = transactiontype;
		this.transactionamount = transactionamount;
		this.transactiondate = transactiondate;
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public String getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}

	public double getTransactionamount() {
		return transactionamount;
	}

	public void setTransactionamount(double transactionamount) {
		this.transactionamount = transactionamount;
	}

	public Date getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}

	@Override
	public String toString() {
		return "BankTransaction [transactionid=" + transactionid + ", accountid=" + accountid + ", transactiontype="
				+ transactiontype + ", transactionamount=" + transactionamount + ", transactiondate=" + transactiondate
				+ "]";
	}
	
	

}
