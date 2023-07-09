package com.task.leasingcontract.service;

import com.task.leasingcontract.model.LeasingContract;

public interface LeasingContractService {
    LeasingContract addLeasingContract(LeasingContract leasingContract);
    LeasingContract editLeasingContract(LeasingContract leasingContract);
    void deleteLeasingContract(LeasingContract leasingContract);
}
