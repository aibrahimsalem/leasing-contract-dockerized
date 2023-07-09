package com.task.leasingcontract.mapper.impl;

import com.task.leasingcontract.dto.CustomerDto;
import com.task.leasingcontract.mapper.CustomerSourceDestinationMapper;
import com.task.leasingcontract.model.Customer;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CustomerSourceDestinationMapperImpl implements CustomerSourceDestinationMapper {
    @Override
    public CustomerDto mapCustomerToCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(String.valueOf(customer.getId()));
        customerDto.setBirthdate(String.valueOf(customer.getBirthdate()));
        customerDto.setFirstname(customer.getFirstname());
        customerDto.setLastname(customer.getLastname());
        return customerDto;
    }

    @Override
    public Customer mapCustomerDtoToCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId().isEmpty() ? 1 : Long.parseLong(customerDto.getId()));
        customer.setFirstname(customerDto.getFirstname());
        customer.setLastname(customerDto.getLastname());

        try {
            customer.setBirthdate(convertStringToDate(customerDto.getBirthdate()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    private Date convertStringToDate(String customerDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(customerDate);
    }
}
