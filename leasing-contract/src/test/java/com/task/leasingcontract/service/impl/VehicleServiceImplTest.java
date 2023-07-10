package com.task.leasingcontract.service.impl;

import com.task.leasingcontract.model.Vehicle;
import com.task.leasingcontract.repository.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceImplTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @Test
    public void testAddVehicle() {
        Vehicle vehicle = new Vehicle();

        Vehicle savedVehicle = new Vehicle();

        when(vehicleRepository.save(vehicle)).thenReturn(savedVehicle);

        Vehicle result = vehicleService.addVehicle(vehicle);

        assertEquals(savedVehicle, result);
    }

    @Test
    public void testEditVehicle_ExistingVehicle() {
        Vehicle vehicle = new Vehicle();

        Vehicle storedVehicle = new Vehicle();

        when(vehicleRepository.findById(vehicle.getId())).thenReturn(Optional.of(storedVehicle));
        when(vehicleRepository.save(storedVehicle)).thenReturn(storedVehicle);

        Vehicle result = vehicleService.editVehicle(vehicle);

        assertEquals(storedVehicle, result);
        verify(vehicleRepository, times(1)).save(storedVehicle);
    }

    @Test
    public void testEditVehicle_NonExistingVehicle() {
        Vehicle vehicle = new Vehicle();

        when(vehicleRepository.findById(vehicle.getId())).thenReturn(Optional.empty());
        when(vehicleRepository.save(vehicle)).thenReturn(vehicle);

        Vehicle result = vehicleService.editVehicle(vehicle);

        assertEquals(vehicle, result);
        verify(vehicleRepository, times(1)).save(vehicle);
    }

    @Test
    public void testDeleteVehicle() {
        Vehicle vehicle = new Vehicle();

        vehicleService.deleteVehicle(vehicle);

        verify(vehicleRepository, times(1)).delete(vehicle);
    }

    @Test
    public void testFindVehicleById_ExistingVehicle() {
        Long vehicleId = 12345L;
        Vehicle vehicle = new Vehicle();

        when(vehicleRepository.findById(vehicleId)).thenReturn(Optional.of(vehicle));

        Vehicle result = vehicleService.findVehicleById(vehicleId.toString());

        assertEquals(vehicle, result);
    }

    @Test
    public void testFindVehicleById_NonExistingVehicle() {
        Long vehicleId = 12345L;

        when(vehicleRepository.findById(vehicleId)).thenReturn(Optional.empty());

        Vehicle result = vehicleService.findVehicleById(vehicleId.toString());

        assertNull(result);
    }

    @Test
    public void testFindAllVehicles() {
        Iterable<Vehicle> allVehicles = Collections.singletonList(new Vehicle());

        when(vehicleRepository.findAll()).thenReturn(allVehicles);

        List<Vehicle> result = vehicleService.findAllVehicles();

        assertEquals(allVehicles, result);
    }
}
