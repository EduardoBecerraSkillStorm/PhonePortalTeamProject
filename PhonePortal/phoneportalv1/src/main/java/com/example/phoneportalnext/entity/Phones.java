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
public class Phones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer phone_id;
	
	@Column
	private Integer monthly_price;
	
	@Column
	private Integer phone_number;
	
	@Column
	private String device_name;
	


	public Integer getPhone_id() {
		return phone_id;
	}


	public void setPhone_id(Integer phone_id) {
		this.phone_id = phone_id;
	}

	public Integer getMonthly_price() {
		return monthly_price;
	}

	public void setMonthly_price(Integer monthly_price) {
		this.monthly_price = monthly_price;
	}

	public Integer getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(Integer phone_number) {
		this.phone_number = phone_number;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	
	
		
	



	
	
}
