package com.task.leasingcontract.facade;

import com.task.leasingcontract.dto.VehicleDto;
import com.task.leasingcontract.mapper.VehicleSourceDestinationMapper;
import com.task.leasingcontract.model.Vehicle;
import com.task.leasingcontract.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehicleFacadeTest {

    @Mock
    private VehicleSourceDestinationMapper vehicleSourceDestinationMapper;

    @Mock
    private VehicleService vehicleService;

    @InjectMocks
    private VehicleFacade vehicleFacade;
    
    @Test
    public void testAddVehicle() {
        // Mock data
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId(String.valueOf(1L));
        vehicleDto.setBrand("BMW");

        Vehicle vehicle = new Vehicle();
        vehicle.setId(1L);
        vehicle.setBrand("BMW");

        when(vehicleSourceDestinationMapper.mapVehicleDtoToVehicle(vehicleDto)).thenReturn(vehicle);
        when(vehicleService.addVehicle(vehicle)).thenReturn(vehicle);
        when(vehicleSourceDestinationMapper.mapVehicleToVehicleDto(vehicle)).thenReturn(vehicleDto);

        // Call the method
        VehicleDto result = vehicleFacade.addVehicle(vehicleDto);

        // Verify the mapper and service method were called correctly
        verify(vehicleSourceDestinationMapper, times(1)).mapVehicleDtoToVehicle(vehicleDto);
        verify(vehicleService, times(1)).addVehicle(vehicle);
        verify(vehicleSourceDestinationMapper, times(1)).mapVehicleToVehicleDto(vehicle);

        // Verify the result
        assertEquals(vehicleDto, result);
    }

    @Test
    public void testEditVehicle() {
        // Mock data
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId(String.valueOf(1L));
        vehicleDto.setBrand("BMW");

        Vehicle vehicle = new Vehicle();
        vehicle.setId(1L);
        vehicle.setBrand("BMW");

        when(vehicleSourceDestinationMapper.mapVehicleDtoToVehicle(vehicleDto)).thenReturn(vehicle);
        when(vehicleService.editVehicle(vehicle)).thenReturn(vehicle);
        when(vehicleSourceDestinationMapper.mapVehicleToVehicleDto(vehicle)).thenReturn(vehicleDto);

        // Call the method
        VehicleDto result = vehicleFacade.editVehicle(vehicleDto);

        // Verify the mapper and service method were called correctly
        verify(vehicleSourceDestinationMapper, times(1)).mapVehicleDtoToVehicle(vehicleDto);
        verify(vehicleService, times(1)).editVehicle(vehicle);
        verify(vehicleSourceDestinationMapper, times(1)).mapVehicleToVehicleDto(vehicle);

        // Verify the result
        assertEquals(vehicleDto, result);
    }

    @Test
    public void testDeleteVehicle() {
        // Mock data
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId(String.valueOf(1L));
        vehicleDto.setBrand("BMW");

        Vehicle vehicle = new Vehicle();
        vehicle.setId(1L);
        vehicle.setBrand("BMW");

        when(vehicleSourceDestinationMapper.mapVehicleDtoToVehicle(vehicleDto)).thenReturn(vehicle);

        // Call the method
        vehicleFacade.deleteVehicle(vehicleDto);

        // Verify the mapper and service method were called correctly
        verify(vehicleSourceDestinationMapper, times(1)).mapVehicleDtoToVehicle(vehicleDto);
        verify(vehicleService, times(1)).deleteVehicle(vehicle);
    }

    @Test
    public void testFindVehicleById() {
        // Mock data
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId(String.valueOf(1L));
        vehicleDto.setBrand("BMW");

        Vehicle vehicle = new Vehicle();
        vehicle.setId(1L);
        vehicle.setBrand("BMW");

        when(vehicleService.findVehicleById("1")).thenReturn(vehicle);
        when(vehicleSourceDestinationMapper.mapVehicleToVehicleDto(vehicle)).thenReturn(vehicleDto);

        // Call the method
        VehicleDto result = vehicleFacade.findVehicleById("1");

        // Verify the service method and mapper were called correctly
        verify(vehicleService, times(1)).findVehicleById("1");
        verify(vehicleSourceDestinationMapper, times(1)).mapVehicleToVehicleDto(vehicle);

        // Verify the result
        assertEquals(vehicleDto, result);
    }

    @Test
    public void testFindAllVehicles() {
        // Mock data
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setId(1L);
        vehicle1.setBrand("Car");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setId(2L);
        vehicle2.setBrand("Motorcycle");

        List<Vehicle> mockVehicles = Arrays.asList(vehicle1, vehicle2);

        // Stubbing the vehicleService to return the mockVehicles
        when(vehicleService.findAllVehicles()).thenReturn(mockVehicles);

        // Mock mapping
        VehicleDto dto1 = new VehicleDto();
        dto1.setId(String.valueOf(1));
        dto1.setBrand("Car");

        VehicleDto dto2 = new VehicleDto();
        dto2.setId(String.valueOf(2));
        dto2.setBrand("Motorcycle");

        List<VehicleDto> expectedDtoList = Arrays.asList(dto1, dto2);

        // Stubbing the vehicleSourceDestinationMapper to return the expectedDtoList
        when(vehicleSourceDestinationMapper.mapVehicleToVehicleDto(any(Vehicle.class)))
                .thenReturn(dto1, dto2);

        // Call the method to test
        List<VehicleDto> result = vehicleFacade.findAllVehicles();

        // Verify the interactions and assertions
        verify(vehicleService, times(1)).findAllVehicles();
        verify(vehicleSourceDestinationMapper, times(2)).mapVehicleToVehicleDto(any(Vehicle.class));

        assertEquals(expectedDtoList, result);
    }
}