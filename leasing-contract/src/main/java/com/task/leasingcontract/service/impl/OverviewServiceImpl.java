package com.task.leasingcontract.service.impl;

import com.task.leasingcontract.dto.OverviewDto;
import com.task.leasingcontract.repository.OverviewRepository;
import com.task.leasingcontract.service.OverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OverviewServiceImpl implements OverviewService {

    @Autowired
    private OverviewRepository overviewRepository;

    public OverviewDto findLeasingContract(Long leasingContractNumber) {
        return overviewRepository.findLeasingContractByContractId(leasingContractNumber);
    }
}
