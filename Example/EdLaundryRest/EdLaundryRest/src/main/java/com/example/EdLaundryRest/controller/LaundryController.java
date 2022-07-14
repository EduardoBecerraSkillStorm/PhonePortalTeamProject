package com.example.EdLaundryRest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EdLaundryRest.entity.Dropoff;
import com.example.EdLaundryRest.entity.Hamper;
import com.example.EdLaundryRest.entity.Pickup;
import com.example.EdLaundryRest.entity.PoundsAtLaundry;
import com.example.EdLaundryRest.laundryService.LaundryService;
import com.example.EdLaundryRest.repository.DropoffRepo;
import com.example.EdLaundryRest.repository.HamperRepo;
import com.example.EdLaundryRest.repository.PickupRepo;

import java.text.DecimalFormat;

/*
 * Welcome to my Laundry application. 
 * This application is based how I’ve seen laundries in las vegas handle linen for hotels.
 * This is a H2 database. 
 * Please see the end of the file for the sample curl commands.
 * 
 * Sincerely, 
 * Eduardo Becerra (Ed)
 */

@RestController
public class LaundryController {
	
	
	private final HamperRepo hamperRepo;
	private final PickupRepo pickupRepo;
	private final DropoffRepo dropoffRepo;
	private final LaundryService laundryService;
	
	public LaundryController (
			HamperRepo hamperRepo,
			PickupRepo pickupRepo,
			DropoffRepo dropoffRepo,
			LaundryService laundryService) {
		this.hamperRepo = hamperRepo;
		this.pickupRepo = pickupRepo;
		this.dropoffRepo = dropoffRepo;
		this.laundryService = laundryService;
	}
	
	//Make a new Hamper.
	@PostMapping("/laundry/hamper")
	public Hamper newHamper(@RequestBody Hamper hamper) {
		Hamper newHamper = this.hamperRepo.save(hamper);
		return newHamper;
	}
	
	//Get all hampers.
	@GetMapping("/laundry/hamper")
	public Iterable<Hamper> getAllHampers(){
		return this.hamperRepo.findAll();
	}
	
	//Find hamper.
	@GetMapping("/laundry/{hamperNumber}")
	public Optional<Hamper> getHamperWeight(@PathVariable final Integer hamperNumber) {
		return hamperRepo.findById(hamperNumber);
	}
	
	//Get all pickups.
	@GetMapping("/laundry/pickup")
	public Iterable<Pickup> getAllPickups(){
		return this.pickupRepo.findAll();
	}
	
	//Get all dropoffs.
	@GetMapping("/laundry/dropoff")
	public Iterable<Dropoff> getAllDropoffs(){
		return this.dropoffRepo.findAll();
	}
	
	//Get pounds left from the laundry.
	@GetMapping("/laundry/poundsLeftAtLaundry")
	public Integer poundsLeft() {
		Integer poundsLeftUpdate = PoundsAtLaundry.getLeftAtLaundry();
		return poundsLeftUpdate;
	}
	
	//Get all invoices, paid or unpaid.
	@RequestMapping(value="laundry/invoicePaid/{invoicePaid}")
	public List<Dropoff> getInvoiceStatus(@PathVariable String invoicePaid) {
		return laundryService.getAllByInvoiceStatus(invoicePaid);
	}
	
	//Make a new laundry pick up.
	@PostMapping("/laundry/pickup")
	public Pickup hamperPickup(@RequestBody Pickup pickup) {
		
		//Getting hamper weight and subctracting from the gross weight.	
		//To get the net weight.	
		Integer hamperNumberEntered = pickup.getHamperNumber();	
		Optional<Hamper> hamperEnteredOptional = getHamperWeight(hamperNumberEntered);
		if(!hamperEnteredOptional.isPresent()) {
			return null;
		}
		Hamper hamperEntered = hamperEnteredOptional.get();
		Integer hamperWeight = hamperEntered.getHamperWeight();
		Integer grossPickup = pickup.getPickupGrossLb();
		Integer netPickup = grossPickup - hamperWeight;
		if(grossPickup < hamperWeight) {
		netPickup = 0;
		}
		pickup.setPickupNetLB(netPickup);
	
		//Adding the net weight from the total weight at the laundry. 
	
		Integer leftAtLaundry = PoundsAtLaundry.getLeftAtLaundry();
		Integer newLeftOnLaundry = netPickup + leftAtLaundry;
		PoundsAtLaundry.setLeftAtLaundry(newLeftOnLaundry);
	
		//Updating the totalPoundsLeftAtLaundry field from the pick up entity.
		//So the user can see whats left at the laundry from this POST.
		pickup.setTotalPoundsLeftAtLaundry(newLeftOnLaundry);
	
		Pickup newPickup = this.pickupRepo.save(pickup);
		return newPickup;
		}
	
	//Make a new Dropoff
	@PostMapping("/laundry/dropoff")
	public Dropoff hamperDropoff(@RequestBody Dropoff dropoff) {
		
		//Getting hamper weight and subctracting from the gross weight.	
		//To get the net weight.
		Integer hamperNumberEntered = dropoff.getHamperNumber();
		Optional<Hamper> hamperEnteredOptional = getHamperWeight(hamperNumberEntered);
		if(!hamperEnteredOptional.isPresent()) {
			return null;
		}
		Hamper hamperEntered = hamperEnteredOptional.get();
		Integer hamperWeight = hamperEntered.getHamperWeight();
		Integer grossDropoff = dropoff.getDropoffGrossLb();
		Integer netDropoff = grossDropoff - hamperWeight;
		if(grossDropoff < hamperWeight) {
			netDropoff = 0;
		}
		
		dropoff.setDropoffNetLB(netDropoff);
		
		//Subtracting the net weight from the total weight at the laundry. 
		Integer leftAtLaundry = PoundsAtLaundry.getLeftAtLaundry();
		Integer newLeftAtLaundry = leftAtLaundry - netDropoff;
		PoundsAtLaundry.setLeftAtLaundry(newLeftAtLaundry);
		
		//Calculating the invoice amount based on the netDropoff and 55 cents per pound.
		//Also keeping keeping the format to dollars and cents. 
		DecimalFormat df = new DecimalFormat("0.00");
		String rounded = df.format(netDropoff * .55);
		dropoff.setInvoice(Double.valueOf(rounded));
	
		//Updating the totalPoundsLeftAtLaundry field from the pick up entity.
		//So the user can see whats left at the laundry from this POST.
		dropoff.setTotalPoundsLeftAtLaundry(newLeftAtLaundry);
		
		Dropoff newDropoff = this.dropoffRepo.save(dropoff);
		return newDropoff;
		}
	
	//Update a dropoff by invoiceNumber.
	@PutMapping("/laundry/dropoff/{invoiceNumber}")
	public Dropoff updateDropoff(@PathVariable("invoiceNumber") Integer invoiceNumber, @RequestBody Dropoff dropoff ) {
		Optional<Dropoff> dropoffOptional = this.dropoffRepo.findById(invoiceNumber);
		if(!dropoffOptional.isPresent()) {
			return null;
		}
		
		//Update invoiceStatus.
		Dropoff dropoffFound = dropoffOptional.get();
		String statusEntered = dropoff.getInvoiceStatus();
		dropoffFound.setInvoiceStatus(statusEntered.toLowerCase());
	
		this.dropoffRepo.save(dropoffFound);
		return dropoffFound;		
	}
	
	//Delete a pickup.
	@DeleteMapping("/laundry/pickup/{id}")
	public Pickup deletePickup(@PathVariable("id") Integer id) {
		Optional<Pickup> deletePickupOptional = this.pickupRepo.findById(id);
		if(!deletePickupOptional.isPresent()) {
			return null;
		}
		Pickup pickupToDelete = deletePickupOptional.get();
		this.pickupRepo.delete(pickupToDelete);
		return pickupToDelete;
	}
	
	//Delete a dropoff.
	@DeleteMapping("/laundry/dropoff/{invoiceNumber}")
	public Dropoff deleteDropoff(@PathVariable("invoiceNumber") Integer invoiceNumber) {
		Optional<Dropoff> deleteDropoffOptional = this.dropoffRepo.findById(invoiceNumber);
		if(!deleteDropoffOptional.isPresent()) {
			return null;
		}
		Dropoff dropoffToDelete = deleteDropoffOptional.get();
		this.dropoffRepo.delete(dropoffToDelete);
		return dropoffToDelete;
	}
	
	//Delete a hamper.
	@DeleteMapping("/laundry/hamper/{hamperNumber}")
	public Hamper deleteHamper(@PathVariable("hamperNumber") Integer hamperNumber) {
		Optional<Hamper> deleteHamperOptional = this.hamperRepo.findById(hamperNumber);
		if(!deleteHamperOptional.isPresent()) {
			return null;
		}
		Hamper hamperToDelete = deleteHamperOptional.get();
		this.hamperRepo.delete(hamperToDelete);
		return hamperToDelete;
	}

}

/*

Once this application is running on a server copy and paste the following curl commands to command prompt...

Add a new hamper:
curl -X POST localhost:8080/laundry/hamper -H "Content-Type: application/json" -d "{\"hamperNumber\":\"3748\", \"hamperWeight\":\"140\"}"
curl -X POST localhost:8080/laundry/hamper -H "Content-Type: application/json" -d "{\"hamperNumber\":\"465\", \"hamperWeight\":\"130\"}"

Make a new pickup:
curl -X POST localhost:8080/laundry/pickup -H "Content-Type: application/json" -d "{\"hamperNumber\":\"3748\", \"pickupGrossLb\":\"1000\"}"
curl -X POST localhost:8080/laundry/pickup -H "Content-Type: application/json" -d "{\"hamperNumber\":\"465\", \"pickupGrossLb\":\"500\"}"

Make a new dropoff:
curl -X POST localhost:8080/laundry/dropoff -H "Content-Type: application/json" -d "{\"hamperNumber\":\"3748\", \"dropoffGrossLb\":\"400\"}"
curl -X POST localhost:8080/laundry/dropoff -H "Content-Type: application/json" -d "{\"hamperNumber\":\"465\", \"dropoffGrossLb\":\"300\"}"

See pounds left at Laundry:
curl localhost:8080/laundry/poundsLeftAtLaundry

Once the customer has paid an invoice  
update an invoiceStatus to closed by invoice:
curl -X PUT localhost:8080/laundry/dropoff/1 -H "Content-Type: application/json" -d "{\"invoiceStatus\":\"closed\"}"

See all invoices unpaid:
curl localhost:8080/laundry/invoicePaid/open"

See all invoices paid:
curl localhost:8080/laundry/invoicePaid/closed"

See all pickups:
curl localhost:8080/laundry/pickup"

See all dropoffs:
curl localhost:8080/laundry/dropoff"

See all hampers:
curl localhost:8080/laundry/hamper"

Delete a pickup:
curl -X DELETE localhost:8080/laundry/pickup/1

Delete a dropoff:
curl -X DELETE localhost:8080/laundry/dropoff/1

Delete a hamper:
curl -X DELETE localhost:8080/laundry/hamper/3748

*/
