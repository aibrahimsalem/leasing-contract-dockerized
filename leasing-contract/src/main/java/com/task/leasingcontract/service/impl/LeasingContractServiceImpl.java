package com.task.leasingcontract.service.impl;

import com.task.leasingcontract.model.LeasingContract;
import com.task.leasingcontract.repository.LeasingContractRepository;
import com.task.leasingcontract.service.LeasingContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeasingContractServiceImpl implements LeasingContractService {

    @Autowired
    private LeasingContractRepository leasingContractRepository;

    @Override
    public long addLeasingContract(LeasingContract leasingContract) {
        return 0;
    }

    @Override
    public long editLeasingContract(LeasingContract leasingContract) {
        return 0;
    }

    @Override
    public long deleteLeasingContract(LeasingContract leasingContract) {
        return 0;
    }
}
