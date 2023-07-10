package com.task.leasingcontract.dto;


import lombok.Data;

public interface OverviewDto {

    String getContractNumber();
    String getFirstname();
    String getLastname();
    String getBrand();
    String getModel();
    String getModelYear();
    String getVehicleIdentificationNumber();
    String getMonthlyRate();
    String getPrice();
}
