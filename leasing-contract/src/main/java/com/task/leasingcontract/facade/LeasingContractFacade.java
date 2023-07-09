package com.task.leasingcontract.facade;

import com.task.leasingcontract.dto.LeasingContractDto;
import com.task.leasingcontract.mapper.LeasingContractSourceDestinationMapper;
import com.task.leasingcontract.model.LeasingContract;
import com.task.leasingcontract.service.LeasingContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LeasingContractFacade {

    @Autowired
    private LeasingContractSourceDestinationMapper mapper;
    @Autowired
    private LeasingContractService leasingContractService;

    public LeasingContractDto addLeasingContract(LeasingContractDto leasingContractDto) {
        LeasingContract leasingContract = mapper.mapLeasingContractDtoToLeasingContract(leasingContractDto);
        leasingContract = leasingContractService.addLeasingContract(leasingContract);
        return mapper.mapLeasingContractToLeasingContractDto(leasingContract);
    }

    public LeasingContractDto editLeasingContract(LeasingContractDto leasingContractDto) {
        LeasingContract leasingContract = mapper.mapLeasingContractDtoToLeasingContract(leasingContractDto);
        leasingContract = leasingContractService.editLeasingContract(leasingContract);
        return mapper.mapLeasingContractToLeasingContractDto(leasingContract);
    }

    public void deleteLeasingContract(LeasingContractDto leasingContractDto) {
        LeasingContract leasingContract = mapper.mapLeasingContractDtoToLeasingContract(leasingContractDto);
        leasingContractService.deleteLeasingContract(leasingContract);
    }
}
