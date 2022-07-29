package com.example.phoneportalnext.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table
@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer user_id;
	
	@Column
	private String name;
	
	@Column
	private String pass;

	@Column
	private String plan_name;
	
	@Column
	private Integer monthly_price;
	
	@Column
	private String phone_number_1;
	
	@Column
	private String device_name_1;
	
	@Column
	private String phone_number_2;
	
	@Column
	private String device_name_2;
	
	@Column
	private String phone_number_3;
	
	@Column
	private String device_name_3;
	
	@Column
	private String phone_number_4;
	
	@Column
	private String device_name_4;



	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getPlan_name() {
		return plan_name;
	}


	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}


	public Integer getMonthly_price() {
		return monthly_price;
	}


	public void setMonthly_price(Integer monthly_price) {
		this.monthly_price = monthly_price;
	}


	public String getPhone_number_1() {
		return phone_number_1;
	}


	public void setPhone_number_1(String phone_number_1) {
		this.phone_number_1 = phone_number_1;
	}


	public String getDevice_name_1() {
		return device_name_1;
	}


	public void setDevice_name_1(String device_name_1) {
		this.device_name_1 = device_name_1;
	}


	public String getPhone_number_2() {
		return phone_number_2;
	}


	public void setPhone_number_2(String phone_number_2) {
		this.phone_number_2 = phone_number_2;
	}


	public String getDevice_name_2() {
		return device_name_2;
	}


	public void setDevice_name_2(String device_name_2) {
		this.device_name_2 = device_name_2;
	}


	public String getPhone_number_3() {
		return phone_number_3;
	}


	public void setPhone_number_3(String phone_number_3) {
		this.phone_number_3 = phone_number_3;
	}


	public String getDevice_name_3() {
		return device_name_3;
	}


	public void setDevice_name_3(String device_name_3) {
		this.device_name_3 = device_name_3;
	}


	public String getPhone_number_4() {
		return phone_number_4;
	}


	public void setPhone_number_4(String phone_number_4) {
		this.phone_number_4 = phone_number_4;
	}


	public String getDevice_name_4() {
		return device_name_4;
	}


	public void setDevice_name_4(String device_name_4) {
		this.device_name_4 = device_name_4;
	}

   


}
