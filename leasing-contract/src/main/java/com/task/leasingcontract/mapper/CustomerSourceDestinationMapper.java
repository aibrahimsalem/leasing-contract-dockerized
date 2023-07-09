package com.task.leasingcontract.mapper;

import com.task.leasingcontract.dto.CustomerDto;
import com.task.leasingcontract.dto.LeasingContractDto;
import com.task.leasingcontract.model.Customer;
import com.task.leasingcontract.model.LeasingContract;


public interface CustomerSourceDestinationMapper {

    CustomerDto mapCustomerToCustomerDto(Customer customer);
    Customer mapCustomerDtoToCustomer(CustomerDto customerDto);

}
