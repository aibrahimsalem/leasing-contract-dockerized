package com.task.leasingcontract.service.impl;

import com.task.leasingcontract.model.Customer;
import com.task.leasingcontract.model.Vehicle;
import com.task.leasingcontract.repository.VehicleRepository;
import com.task.leasingcontract.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle editVehicle(Vehicle vehicle) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicle.getId());
        if (vehicleOptional.isPresent()) {
            Vehicle storedVehicle = vehicleOptional.get();
            storedVehicle.setPrice(vehicle.getPrice());
            storedVehicle.setBrand(vehicle.getBrand());
            storedVehicle.setModel(vehicle.getModel());
            storedVehicle.setModelYear(vehicle.getModelYear());
            storedVehicle.setVehicleIdentificationNumber(vehicle.getVehicleIdentificationNumber());
            return vehicleRepository.save(storedVehicle);
        }
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
    }
}
