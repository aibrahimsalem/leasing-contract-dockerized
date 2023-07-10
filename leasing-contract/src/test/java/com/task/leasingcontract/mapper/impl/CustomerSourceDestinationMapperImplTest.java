package com.task.leasingcontract.mapper.impl;

import com.task.leasingcontract.dto.CustomerDto;
import com.task.leasingcontract.mapper.CustomerSourceDestinationMapper;
import com.task.leasingcontract.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerSourceDestinationMapperImplTest {

    private CustomerSourceDestinationMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = new CustomerSourceDestinationMapperImpl();
    }

    @Test
    public void testMapCustomerToCustomerDto() {
        // Given
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setBirthdate(parseDate("1990-01-01"));
        customer.setFirstname("Ali");
        customer.setLastname("Ali");

        // When
        CustomerDto customerDto = mapper.mapCustomerToCustomerDto(customer);

        // Then
        Assertions.assertEquals("1", customerDto.getId());
        Assertions.assertEquals("Mon Jan 01 00:00:00 CET 1990", customerDto.getBirthdate());
        Assertions.assertEquals("Ali", customerDto.getFirstname());
        Assertions.assertEquals("Ali", customerDto.getLastname());
    }

    @Test
    public void testMapCustomerDtoToCustomer() {
        // Given
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId("1");
        customerDto.setBirthdate("1990-01-01");
        customerDto.setFirstname("HyA");
        customerDto.setLastname("HYB");

        // When
        Customer customer = mapper.mapCustomerDtoToCustomer(customerDto);

        // Then
        Assertions.assertEquals(1L, customer.getId());
        Assertions.assertEquals("1990-01-01", formatDate(customer.getBirthdate()));
        Assertions.assertEquals("HyA", customer.getFirstname());
        Assertions.assertEquals("HYB", customer.getLastname());
    }

    private Date parseDate(String dateString) {
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private String formatDate(Date date) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }
}
