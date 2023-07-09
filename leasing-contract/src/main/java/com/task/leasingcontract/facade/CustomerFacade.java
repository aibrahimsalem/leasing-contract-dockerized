package com.task.leasingcontract.facade;

import com.task.leasingcontract.dto.CustomerDto;
import com.task.leasingcontract.mapper.CustomerSourceDestinationMapper;
import com.task.leasingcontract.model.Customer;
import com.task.leasingcontract.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerFacade {

    @Autowired
    private CustomerSourceDestinationMapper customerSourceDestinationMapper;

    @Autowired
    private CustomerService customerService;

    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer = customerSourceDestinationMapper.mapCustomerDtoToCustomer(customerDto);
        customer = customerService.addCustomer(customer);
        return customerSourceDestinationMapper.mapCustomerToCustomerDto(customer);
    }

    public CustomerDto editCustomer(CustomerDto customerDto) {
        Customer customer = customerSourceDestinationMapper.mapCustomerDtoToCustomer(customerDto);
        customer = customerService.editCustomer(customer);
        return customerSourceDestinationMapper.mapCustomerToCustomerDto(customer);
    }

    public void deleteCustomer(CustomerDto customerDto) {
        Customer customer = customerSourceDestinationMapper.mapCustomerDtoToCustomer(customerDto);
        customerService.deleteCustomer(customer);
    }
}
