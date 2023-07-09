package com.task.leasingcontract.service.impl;

import com.task.leasingcontract.model.LeasingContract;
import com.task.leasingcontract.repository.LeasingContractRepository;
import com.task.leasingcontract.service.LeasingContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeasingContractServiceImpl implements LeasingContractService {

    @Autowired
    private LeasingContractRepository leasingContractRepository;

    @Override
    public LeasingContract addLeasingContract(LeasingContract leasingContract) {
        return leasingContractRepository.save(leasingContract);
    }

    @Override
    public LeasingContract editLeasingContract(LeasingContract leasingContract) {
        Optional<LeasingContract> leasingContractOptional = leasingContractRepository.findById(leasingContract.getId());
        if (leasingContractOptional.isPresent()) {
            LeasingContract storedLeasingContract = leasingContractOptional.get();
            storedLeasingContract.setContractNumber(leasingContract.getContractNumber());
            storedLeasingContract.setMonthlyRate(leasingContract.getMonthlyRate());
            return leasingContractRepository.save(storedLeasingContract);
        }
        return leasingContractRepository.save(leasingContract);
    }

    @Override
    public void deleteLeasingContract(LeasingContract leasingContract) {
        leasingContractRepository.delete(leasingContract);
    }
}
