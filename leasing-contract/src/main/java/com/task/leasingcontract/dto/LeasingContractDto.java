package com.task.leasingcontract.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeasingContractDto {

    private String id;
    private String contractNumber;
    private String monthlyRate;
    private String customerId;
    private String vehicleId;
}
