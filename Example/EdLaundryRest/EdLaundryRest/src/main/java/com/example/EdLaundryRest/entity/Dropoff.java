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
public class Dropoff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer invoiceNumber;
	
	@Column
	@CreationTimestamp
	private LocalDate date;
	
	@Column
	private Integer hamperNumber;
	
	@Column
	private Integer dropoffGrossLb;
	
	@Column
	private Integer dropoffNetLB;
	
	@Column
	private Double invoice; 
	
	@Column
	private String invoiceStatus = "open";
	
	@Column
	private Integer totalPoundsLeftAtLaundry;

	public Integer getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(Integer invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getDropoffGrossLb() {
		return dropoffGrossLb;
	}

	public void setDropoffGrossLb(Integer dropoffGrossLb) {
		this.dropoffGrossLb = dropoffGrossLb;
	}

	public Double getInvoice() {
		return invoice;
	}

	public void setInvoice(Double invoice) {
		this.invoice = invoice;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public Integer getTotalPoundsLeftAtLaundry() {
		return totalPoundsLeftAtLaundry;
	}

	public void setTotalPoundsLeftAtLaundry(Integer totalPoundsLeftAtLaundry) {
		this.totalPoundsLeftAtLaundry = totalPoundsLeftAtLaundry;
	}

	public Integer getHamperNumber() {
		return hamperNumber;
	}

	public void setHamperNumber(Integer hamperNumber) {
		this.hamperNumber = hamperNumber;
	}

	public Integer getDropoffNetLB() {
		return dropoffNetLB;
	}

	public void setDropoffNetLB(Integer dropoffNetLB) {
		this.dropoffNetLB = dropoffNetLB;
	}
	

	
	

}
