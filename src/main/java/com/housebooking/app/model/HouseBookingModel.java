package com.housebooking.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name = "student")
public class HouseBookingModel {
	
	public HouseBookingModel() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String userName;
	private String password;
	private String email;
	private String mobileNo;
	private String address;
	private String buName;
	private String device;
	private String gender;

public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
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
public String getBuName() {
	return buName;
}
public void setBuName(String buName) {
	this.buName = buName;
}
public String getDevice() {
	return device;
}
public void setDevice(String device) {
	this.device = device;
}


}

