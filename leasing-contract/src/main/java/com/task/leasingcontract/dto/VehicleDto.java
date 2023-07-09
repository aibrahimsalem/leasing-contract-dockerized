package com.task.leasingcontract.dto;

import lombok.*;

@Data
public class VehicleDto {

    private String id;
    private String brand;
    private String model;
    private String modelYear;
    private String vehicleIdentificationNumber;
    private String price;
    private String leasingContractId;
}
