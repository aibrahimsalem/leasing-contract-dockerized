package com.task.leasingcontract.controller;

import com.task.leasingcontract.dto.OverviewDto;
import com.task.leasingcontract.service.OverviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/overview")
public class ContractOverview {

    @Autowired
    private OverviewService overviewService;

    @GetMapping(path = "/{id}")
    public OverviewDto getContractOverview(@PathVariable String id) {
        return overviewService.findLeasingContractOverview(Long.parseLong(id));
    }

    @GetMapping
    public List<OverviewDto> getAllContractsOverview() {
        return overviewService.findAllLeasingContractOverview();
    }

}
