package com.dutybank.model;

import java.util.Date;

public class BankClient {
	private int clientid;
	private String clientname;
	private String clientlastname;
	private String clientdocument;
	private String clientgender;
	private Date clientdob;
	private String clientaddress;
	private String clientnationality;
	private double clientsalary;
	private long clientcontact;
	
	public BankClient() {
		// TODO Auto-generated constructor stub
	}

	public BankClient(int clientid, String clientname, String clientlastname, String clientdocument, String clientgender,
			Date clientdob, String clientaddress, String clientnationality, double clientsalary, long clientcontact) {
		super();
		this.clientid = clientid;
		this.clientname = clientname;
		this.clientlastname = clientlastname;
		this.clientdocument = clientdocument;
		this.clientgender = clientgender;
		this.clientdob = clientdob;
		this.clientaddress = clientaddress;
		this.clientnationality = clientnationality;
		this.clientsalary = clientsalary;
		this.clientcontact = clientcontact;
	}

	public int getClientid() {
		return clientid;
	}

	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getClientlastname() {
		return clientlastname;
	}

	public void setClientlastname(String clientlastname) {
		this.clientlastname = clientlastname;
	}

	public String getClientdocument() {
		return clientdocument;
	}

	public void setClientdocument(String clientdocument) {
		this.clientdocument = clientdocument;
	}

	public String getClientgender() {
		return clientgender;
	}

	public void setClientgender(String clientgender) {
		this.clientgender = clientgender;
	}

	public Date getClientdob() {
		return clientdob;
	}

	public void setClientdob(Date clientdob) {
		this.clientdob = clientdob;
	}

	public String getClientaddress() {
		return clientaddress;
	}

	public void setClientaddress(String clientaddress) {
		this.clientaddress = clientaddress;
	}

	public String getClientnationality() {
		return clientnationality;
	}

	public void setClientnationality(String clientnationality) {
		this.clientnationality = clientnationality;
	}

	public double getClientsalary() {
		return clientsalary;
	}

	public void setClientsalary(double clientsalary) {
		this.clientsalary = clientsalary;
	}


	public long getClientcontact() {
		return clientcontact;
	}

	public void setClientcontact(long clientcontact) {
		this.clientcontact = clientcontact;
	}

	@Override
	public String toString() {
		return "BankClient [clientid=" + clientid + ", clientname=" + clientname + ", clientlastname=" + clientlastname
				+ ", clientdocument=" + clientdocument + ", clientgender=" + clientgender + ", clientdob=" + clientdob
				+ ", clientaddress=" + clientaddress + ", clientnationality=" + clientnationality + ", clientsalary="
				+ clientsalary + ", clientcontact=" + clientcontact + "]";
	}
	
	

}
