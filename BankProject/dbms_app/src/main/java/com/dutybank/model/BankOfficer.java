package com.dutybank.model;

import java.util.Date;

public class BankOfficer {
	private int officerid;
	private String officername;
	private String officerlastname;
	private String officerdocument;
	private String officeraddress;
	private long officercontact;
	private String officergender;
	private Date officerdob;
	private String nationality;
	private double officersalary;
	private String officerdepartment;
	private String officerposition;
	
	public BankOfficer() {
		// TODO Auto-generated constructor stub
	}

	public BankOfficer(int officerid, String officername, String officerlastname, String officerdocument,
			String officeraddress, long officercontact, String officergender, Date officerdob, String nationality,
			double officersalary, String officerdepartment, String officerposition) {
		super();
		this.officerid = officerid;
		this.officername = officername;
		this.officerlastname = officerlastname;
		this.officerdocument = officerdocument;
		this.officeraddress = officeraddress;
		this.officercontact = officercontact;
		this.officergender = officergender;
		this.officerdob = officerdob;
		this.nationality = nationality;
		this.officersalary = officersalary;
		this.officerdepartment = officerdepartment;
		this.officerposition = officerposition;
	}

	public int getOfficerid() {
		return officerid;
	}

	public void setOfficerid(int officerid) {
		this.officerid = officerid;
	}

	public String getOfficername() {
		return officername;
	}

	public void setOfficername(String officername) {
		this.officername = officername;
	}

	public String getOfficerlastname() {
		return officerlastname;
	}

	public void setOfficerlastname(String officerlastname) {
		this.officerlastname = officerlastname;
	}

	public String getOfficerdocument() {
		return officerdocument;
	}

	public void setOfficerdocument(String officerdocument) {
		this.officerdocument = officerdocument;
	}

	public String getOfficeraddress() {
		return officeraddress;
	}

	public void setOfficeraddress(String officeraddress) {
		this.officeraddress = officeraddress;
	}

	public long getOfficercontact() {
		return officercontact;
	}

	public void setOfficercontact(long officercontact) {
		this.officercontact = officercontact;
	}

	public String getOfficergender() {
		return officergender;
	}

	public void setOfficergender(String officergender) {
		this.officergender = officergender;
	}

	public Date getOfficerdob() {
		return officerdob;
	}

	public void setOfficerdob(Date officerdob) {
		this.officerdob = officerdob;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public double getOfficersalary() {
		return officersalary;
	}

	public void setOfficersalary(double officersalary) {
		this.officersalary = officersalary;
	}

	public String getOfficerdepartment() {
		return officerdepartment;
	}

	public void setOfficerdepartment(String officerdepartment) {
		this.officerdepartment = officerdepartment;
	}

	public String getOfficerposition() {
		return officerposition;
	}

	public void setOfficerposition(String officerposition) {
		this.officerposition = officerposition;
	}

	@Override
	public String toString() {
		return "BankOfficer [officerid=" + officerid + ", officername=" + officername + ", officerlastname="
				+ officerlastname + ", officerdocument=" + officerdocument + ", officeraddress=" + officeraddress
				+ ", officercontact=" + officercontact + ", officergender=" + officergender + ", officerdob="
				+ officerdob + ", nationality=" + nationality + ", officersalary=" + officersalary
				+ ", officerdepartment=" + officerdepartment + ", officerposition=" + officerposition + "]";
	}
	
	

}
