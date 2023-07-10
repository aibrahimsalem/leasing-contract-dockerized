package com.task.leasingcontract.service;

import com.task.leasingcontract.model.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle editVehicle(Vehicle vehicle);
    void deleteVehicle(Vehicle vehicle);

    Vehicle findVehicleById(String id);

    List<Vehicle> findAllVehicles();
}
