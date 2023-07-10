package com.task.leasingcontract.facade;

import com.task.leasingcontract.dto.VehicleDto;
import com.task.leasingcontract.mapper.VehicleSourceDestinationMapper;
import com.task.leasingcontract.model.Vehicle;
import com.task.leasingcontract.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleFacade {

    @Autowired
    private VehicleSourceDestinationMapper vehicleSourceDestinationMapper;

    @Autowired
    private VehicleService vehicleService;

    public VehicleDto addVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleSourceDestinationMapper.mapVehicleDtoToVehicle(vehicleDto);
        vehicle = vehicleService.addVehicle(vehicle);
        return vehicleSourceDestinationMapper.mapVehicleToVehicleDto(vehicle);
    }

    public VehicleDto editVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleSourceDestinationMapper.mapVehicleDtoToVehicle(vehicleDto);
        vehicle = vehicleService.editVehicle(vehicle);
        return vehicleSourceDestinationMapper.mapVehicleToVehicleDto(vehicle);
    }

    public void deleteVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleSourceDestinationMapper.mapVehicleDtoToVehicle(vehicleDto);
        vehicleService.deleteVehicle(vehicle);
    }
}
