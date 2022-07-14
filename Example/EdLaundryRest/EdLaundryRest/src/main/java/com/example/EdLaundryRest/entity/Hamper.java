package com.example.EdLaundryRest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Hamper {
	
	@Id
	@Column
	private Integer hamperNumber;
	
	@Column
	private Integer hamperWeight;

	public Integer getHamperNumber() {
		return hamperNumber;
	}

	public void setHamperNumber(Integer hamperNumber) {
		this.hamperNumber = hamperNumber;
	}

	public Integer getHamperWeight() {
		return hamperWeight;
	}

	public void setHamperWeight(Integer hamperWeight) {
		this.hamperWeight = hamperWeight;
	}
	

	

}
