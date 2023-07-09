package com.task.leasingcontract.service.impl;

import com.task.leasingcontract.model.Vehicle;
import com.task.leasingcontract.repository.VehicleRepository;
import com.task.leasingcontract.service.VehicleService;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;
    @Override
    public long addVehicle(Vehicle vehicle) {
        return 0;
    }

    @Override
    public long editVehicle(Vehicle vehicle) {
        return 0;
    }

    @Override
    public long deleteVehicle(Vehicle vehicle) {
        return 0;
    }
}
