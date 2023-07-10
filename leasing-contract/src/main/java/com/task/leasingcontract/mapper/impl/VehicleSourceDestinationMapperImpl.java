package com.task.leasingcontract.mapper.impl;

import com.task.leasingcontract.dto.VehicleDto;
import com.task.leasingcontract.mapper.VehicleSourceDestinationMapper;
import com.task.leasingcontract.model.LeasingContract;
import com.task.leasingcontract.model.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleSourceDestinationMapperImpl implements VehicleSourceDestinationMapper {
    @Override
    public VehicleDto mapVehicleToVehicleDto(Vehicle vehicle) {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId(String.valueOf(vehicle.getId()));
        vehicleDto.setBrand(vehicle.getBrand());
        vehicleDto.setVehicleIdentificationNumber(vehicle.getVehicleIdentificationNumber());
        vehicleDto.setModel(vehicle.getModel());
        vehicleDto.setModelYear(vehicle.getModelYear());
        return vehicleDto;
    }

    @Override
    public Vehicle mapVehicleDtoToVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleDto.getId().isEmpty() ? 0 : Long.parseLong(vehicleDto.getId()));
        vehicle.setBrand(vehicleDto.getBrand());
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setModelYear(vehicleDto.getModelYear());
        vehicle.setPrice(Double.parseDouble(vehicleDto.getPrice()));
        vehicle.setVehicleIdentificationNumber(vehicleDto.getVehicleIdentificationNumber());
        return vehicle;
    }
}
