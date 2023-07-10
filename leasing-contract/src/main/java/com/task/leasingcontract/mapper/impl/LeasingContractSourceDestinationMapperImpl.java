package com.task.leasingcontract.mapper.impl;

import com.task.leasingcontract.dto.LeasingContractDto;
import com.task.leasingcontract.mapper.LeasingContractSourceDestinationMapper;
import com.task.leasingcontract.model.Customer;
import com.task.leasingcontract.model.LeasingContract;
import com.task.leasingcontract.model.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class LeasingContractSourceDestinationMapperImpl implements LeasingContractSourceDestinationMapper {
    @Override
    public LeasingContractDto mapLeasingContractToLeasingContractDto(LeasingContract leasingContract) {
        LeasingContractDto leasingContractDto = new LeasingContractDto();
        leasingContractDto.setContractNumber(String.valueOf(leasingContract.getContractNumber()));
        leasingContractDto.setId(String.valueOf(leasingContract.getId()));
        leasingContractDto.setCustomerId(String.valueOf(leasingContract.getCustomer().getId()));
        leasingContractDto.setMonthlyRate(String.valueOf(leasingContract.getMonthlyRate()));
        leasingContractDto.setVehicleId(String.valueOf(leasingContract.getVehicle().getId()));
        return leasingContractDto;
    }

    @Override
    public LeasingContract mapLeasingContractDtoToLeasingContract(LeasingContractDto leasingContractDto) {
        LeasingContract leasingContract = new LeasingContract();
        Customer customer = new Customer();
        Vehicle vehicle = new Vehicle();
        leasingContract.setId(leasingContractDto.getId().isEmpty() ? 0 : Long.parseLong(leasingContractDto.getId()));
        leasingContract.setContractNumber(Long.parseLong(leasingContractDto.getContractNumber()));
        customer.setId(Long.parseLong(leasingContractDto.getCustomerId()));
        leasingContract.setCustomer(customer);
        vehicle.setId(Long.parseLong(leasingContractDto.getVehicleId()));
        leasingContract.setVehicle(vehicle);
        leasingContract.setMonthlyRate(Double.parseDouble(leasingContractDto.getMonthlyRate()));
        return leasingContract;
    }
}
