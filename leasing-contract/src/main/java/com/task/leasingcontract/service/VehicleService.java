package com.task.leasingcontract.service;

import com.task.leasingcontract.model.Vehicle;

public interface VehicleService {
    long addVehicle(Vehicle vehicle);
    long editVehicle(Vehicle vehicle);
    long deleteVehicle(Vehicle vehicle);
}
