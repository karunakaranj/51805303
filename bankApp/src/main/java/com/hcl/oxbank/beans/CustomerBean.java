package com.hcl.oxbank.beans;

public class CustomerBean {
	
	private long id;
	
	private String name;
	
	private String mobileNo;
	
	private String address;
	
	private String gender;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public CustomerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerBean(long id, String name, String mobileNo, String address, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.address = address;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", address=" + address + ", gender="
				+ gender + "]";
	}
}


