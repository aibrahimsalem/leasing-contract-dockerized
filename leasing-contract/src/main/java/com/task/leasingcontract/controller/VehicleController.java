package com.task.leasingcontract.controller;

import com.task.leasingcontract.dto.VehicleDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {

    @PostMapping
    public @ResponseBody String addVehicle(@RequestBody VehicleDto vehicleDto) {
        return "Vehicle Added successfully";
    }

    @PutMapping
    public @ResponseBody String editVehicle(@RequestBody VehicleDto vehicleDto) {
        return "Vehicle Edited successfully";
    }

    @DeleteMapping
    public @ResponseBody String deleteVehicle(@RequestBody VehicleDto vehicleDto) {
        return "Vehicle deleted successfully";
    }
}
