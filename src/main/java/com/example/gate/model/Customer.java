package com.example.gate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customers")
public class Customer {

	private String custName;
	private long mobileNo;
	private String emailId;
	private int aadharNo;
	
	public Customer(String custName, long mobileNo, String emailId, int aadharNo) {
		
		this.custName = custName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.aadharNo = aadharNo;
	}
	
	public Customer() {
		
	}
	
	@Column(name="Name",nullable=false)							//column with customer names
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	@Column(name="MobileNo", nullable=false, unique = true)		//column with unique values
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	@Column(name="EmailId", nullable=false, unique = true)		//column with unique values
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Id
	public int getAadharNo() {									//primary key
		return aadharNo;
	}
	public void setAadharNo(int aadharNo) {
		this.aadharNo = aadharNo;
	}
	
	
	
	
}
