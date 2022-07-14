package com.example.EdLaundryRest.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.EdLaundryRest.entity.Pickup;

public interface PickupRepo extends CrudRepository<Pickup, Integer> {

}
