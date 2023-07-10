package com.task.leasingcontract.service.impl;

import com.task.leasingcontract.model.Vehicle;
import com.task.leasingcontract.repository.VehicleRepository;
import com.task.leasingcontract.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Override
    public Vehicle findVehicleById(String id) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(Long.parseLong(id));
        return vehicleOptional.orElse(null);
    }

    @Override
    public List<Vehicle> findAllVehicles() {
        Iterable<Vehicle> allCustomers = vehicleRepository.findAll();
        return StreamSupport.stream(allCustomers.spliterator(), false)
                .collect(Collectors.toList());
    }
}
