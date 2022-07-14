package com.example.EdLaundryRest.laundryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EdLaundryRest.entity.Dropoff;
import com.example.EdLaundryRest.repository.DropoffRepo;

@Service
public class LaundryService {
	
	@Autowired
	private DropoffRepo dropoffRepo;
	
	public List<Dropoff> getAllByInvoiceStatus(String invoicePaid) {
		return dropoffRepo.getAllByInvoiceStatus(invoicePaid);
	}

}
