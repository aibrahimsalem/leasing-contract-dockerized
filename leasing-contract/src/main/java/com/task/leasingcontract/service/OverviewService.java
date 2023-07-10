package com.task.leasingcontract.service;

import com.task.leasingcontract.dto.OverviewDto;

import java.util.List;

public interface OverviewService {
    OverviewDto findLeasingContractOverview(Long leasingContractNumber);
    List<OverviewDto> findAllLeasingContractOverview();
}
