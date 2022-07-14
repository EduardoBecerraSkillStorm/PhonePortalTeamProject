package com.example.EdLaundryRest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.EdLaundryRest.entity.Dropoff;

public interface DropoffRepo extends CrudRepository<Dropoff, Integer> {

	public List<Dropoff> getAllByInvoiceStatus(String invoicePaid);
	
	
}


