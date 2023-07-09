package com.task.leasingcontract.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {

    private String id;
    private String brand;
    private String model;
    private String modelYear;
    private String vehicleIdentificationNumber;
    private String price;
    private String leasingContractId;
}
