package com.task.leasingcontract.service;

import com.task.leasingcontract.model.Vehicle;

public interface VehicleService {
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle editVehicle(Vehicle vehicle);
    void deleteVehicle(Vehicle vehicle);
}
