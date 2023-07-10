package com.task.leasingcontract.controller;

import com.task.leasingcontract.dto.VehicleDto;
import com.task.leasingcontract.facade.VehicleFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return "Vehicle " + vehicleDto.getId() + " deleted successfully";
    }
}
