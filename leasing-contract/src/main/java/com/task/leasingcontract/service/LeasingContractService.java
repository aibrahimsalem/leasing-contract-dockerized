package com.task.leasingcontract.service;

import com.task.leasingcontract.model.LeasingContract;

public interface LeasingContractService {
    long addLeasingContract(LeasingContract leasingContract);
    long editLeasingContract(LeasingContract leasingContract);
    long deleteLeasingContract(LeasingContract leasingContract);
}
