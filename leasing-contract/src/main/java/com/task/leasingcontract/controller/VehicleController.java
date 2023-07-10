package com.task.leasingcontract.controller;

import com.task.leasingcontract.dto.LeasingContractDto;
import com.task.leasingcontract.dto.VehicleDto;
import com.task.leasingcontract.facade.VehicleFacade;
import com.task.leasingcontract.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {

    @Autowired
    private VehicleFacade vehicleFacade;

    @PostMapping
    public @ResponseBody VehicleDto addVehicle(@RequestBody VehicleDto vehicleDto) {
        return vehicleFacade.addVehicle(vehicleDto);
    }

    @PutMapping
    public @ResponseBody VehicleDto editVehicle(@RequestBody VehicleDto vehicleDto) {
        return vehicleFacade.editVehicle(vehicleDto);
    }

    @DeleteMapping
    public @ResponseBody String deleteVehicle(@RequestBody VehicleDto vehicleDto) {
        vehicleFacade.deleteVehicle(vehicleDto);
        return "Vehicle " + vehicleDto.getId() + " deleted successfully";
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody VehicleDto findVehicleById(@PathVariable String id) {
        return vehicleFacade.findVehicleById(id);
    }

    @GetMapping
    public List<VehicleDto> findAllVehicles() {
        return vehicleFacade.findAllVehicles();
    }
}
