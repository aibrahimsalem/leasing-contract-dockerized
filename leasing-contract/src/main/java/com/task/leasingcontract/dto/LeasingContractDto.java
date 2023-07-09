package com.task.leasingcontract.dto;

import lombok.*;

@Data
public class LeasingContractDto {

    private String id;
    private String contractNumber;
    private String monthlyRate;
    private String customerId;
    private String vehicleId;
}
