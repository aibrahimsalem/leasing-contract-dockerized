package com.task.leasingcontract.mapper;

import com.task.leasingcontract.dto.LeasingContractDto;
import com.task.leasingcontract.model.LeasingContract;


public interface LeasingContractSourceDestinationMapper {

    LeasingContractDto mapLeasingContractToLeasingContractDto(LeasingContract leasingContract);
    LeasingContract mapLeasingContractDtoToLeasingContract(LeasingContractDto leasingContractDto);

}
