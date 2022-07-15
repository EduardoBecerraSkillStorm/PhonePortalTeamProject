package com.PhonePortal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class PhoneNumber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer phoneNumberID;
	
	@Column
	private Integer phoneNumber;
	
	@OneToMany
	@JoinColumn(name = "userNameID")
    private UserName userName;

	
	public Integer getPhoneNumberID() {
		return phoneNumberID;
	}

	public void setPhoneNumberID(Integer phoneNumberID) {
		this.phoneNumberID = phoneNumberID;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UserName getUserName() {
		return userName;
	}

	public void setUserName(UserName userName) {
		this.userName = userName;
	}
}
