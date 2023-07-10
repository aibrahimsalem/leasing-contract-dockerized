package com.task.leasingcontract.service;

import com.task.leasingcontract.model.LeasingContract;

import java.util.List;

public interface LeasingContractService {
    LeasingContract addLeasingContract(LeasingContract leasingContract);
    LeasingContract editLeasingContract(LeasingContract leasingContract);
    void deleteLeasingContract(LeasingContract leasingContract);
    LeasingContract findLeasingContractById(String id);

    List<LeasingContract> findAllLeasingContracts();
}
