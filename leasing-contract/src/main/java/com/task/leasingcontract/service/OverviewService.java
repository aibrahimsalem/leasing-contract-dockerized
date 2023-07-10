package com.task.leasingcontract.service;

import com.task.leasingcontract.dto.OverviewDto;
import com.task.leasingcontract.model.Vehicle;

public interface OverviewService {
    OverviewDto findLeasingContract(Long leasingContractNumber);
}
