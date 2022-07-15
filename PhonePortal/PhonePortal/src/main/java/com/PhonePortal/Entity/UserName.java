package com.PhonePortal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table
public class UserName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer userNameID;
	
	@Column
	private String userName;
	
	@Column
	private String password;
	
	//@OneToOne
	@JoinColumn(name = "planNameID")
    private Plans plan;

	

	public Plans getPlan() {
		return plan;
	}

	public void setPlan(Plans plan) {
		this.plan = plan;
	}


	public Integer getUserNameID() {
		return userNameID;
	}

	public void setUserNameID(Integer userNameID) {
		this.userNameID = userNameID;
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
}
