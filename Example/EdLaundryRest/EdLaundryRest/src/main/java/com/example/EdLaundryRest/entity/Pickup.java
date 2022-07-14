package com.example.EdLaundryRest.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table
public class Pickup {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	@CreationTimestamp
	private LocalDate pickupDate;
	
	@Column
	private Integer hamperNumber;
	
	@Column
	private Integer pickupGrossLb;
	
	@Column 
	private Integer PickupNetLB;
	
	@Column
	private Integer totalPoundsLeftAtLaundry;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(LocalDate pickupDate) {
		this.pickupDate = pickupDate;
	}

	public Integer getHamperNumber() {
		return hamperNumber;
	}

	public void setHamperNumber(Integer hamperNumber) {
		this.hamperNumber = hamperNumber;
	}

	public Integer getPickupGrossLb() {
		return pickupGrossLb;
	}

	public void setPickupGrossLb(Integer pickupGrossLb) {
		this.pickupGrossLb = pickupGrossLb;
	}

	public Integer getPickupNetLB() {
		return PickupNetLB;
	}

	public void setPickupNetLB(Integer pickupNetLB) {
		PickupNetLB = pickupNetLB;
	}

	public Integer getTotalPoundsLeftAtLaundry() {
		return totalPoundsLeftAtLaundry;
	}

	public void setTotalPoundsLeftAtLaundry(Integer totalPoundsLeftAtLaundry) {
		this.totalPoundsLeftAtLaundry = totalPoundsLeftAtLaundry;
	}
	
	


	
	

	
	
	
}
