package com.PhonePortal.Repository;

import org.springframework.data.repository.CrudRepository;

import com.PhonePortal.Entity.Devices;

public interface DeviceRepo extends CrudRepository <Devices, Integer> {

}
