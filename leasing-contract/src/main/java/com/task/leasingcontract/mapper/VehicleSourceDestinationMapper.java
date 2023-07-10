package com.task.leasingcontract.mapper;

import com.task.leasingcontract.dto.VehicleDto;
import com.task.leasingcontract.model.Vehicle;


public interface VehicleSourceDestinationMapper {
    VehicleDto mapVehicleToVehicleDto(Vehicle Vehicle);
    Vehicle mapVehicleDtoToVehicle(VehicleDto VehicleDto);
}
