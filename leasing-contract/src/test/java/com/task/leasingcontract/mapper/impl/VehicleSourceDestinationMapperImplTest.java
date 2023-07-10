package com.task.leasingcontract.mapper.impl;

import com.task.leasingcontract.dto.VehicleDto;
import com.task.leasingcontract.mapper.VehicleSourceDestinationMapper;
import com.task.leasingcontract.model.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VehicleSourceDestinationMapperImplTest {

    private VehicleSourceDestinationMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = new VehicleSourceDestinationMapperImpl();
    }

    @Test
    public void testMapVehicleToVehicleDto() {
        // Given
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1L);
        vehicle.setBrand("Toyota");
        vehicle.setModel("Camry");
        vehicle.setModelYear(String.valueOf(2022));
        vehicle.setVehicleIdentificationNumber("ABC123");

        // When
        VehicleDto vehicleDto = mapper.mapVehicleToVehicleDto(vehicle);

        // Then
        Assertions.assertEquals("1", vehicleDto.getId());
        Assertions.assertEquals("Toyota", vehicleDto.getBrand());
        Assertions.assertEquals("Camry", vehicleDto.getModel());
        Assertions.assertEquals("2022", vehicleDto.getModelYear());
        Assertions.assertEquals("ABC123", vehicleDto.getVehicleIdentificationNumber());
    }

    @Test
    public void testMapVehicleDtoToVehicle() {
        // Given
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId("1");
        vehicleDto.setBrand("Toyota");
        vehicleDto.setModel("Camry");
        vehicleDto.setModelYear(String.valueOf(2022));
        vehicleDto.setPrice("25000.0");
        vehicleDto.setVehicleIdentificationNumber("ABC123");

        // When
        Vehicle vehicle = mapper.mapVehicleDtoToVehicle(vehicleDto);

        // Then
        Assertions.assertEquals(1L, vehicle.getId());
        Assertions.assertEquals("Toyota", vehicle.getBrand());
        Assertions.assertEquals("Camry", vehicle.getModel());
        Assertions.assertEquals("2022", vehicle.getModelYear());
        Assertions.assertEquals(25000.0, vehicle.getPrice());
        Assertions.assertEquals("ABC123", vehicle.getVehicleIdentificationNumber());
    }
}
