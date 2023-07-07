package com.task.leasingcontract.repository;

import org.springframework.data.repository.CrudRepository;

import com.task.leasingcontract.model.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    
}
