package com.task.leasingcontract.service.impl;

import com.task.leasingcontract.model.Customer;
import com.task.leasingcontract.repository.CustomerRepository;
import com.task.leasingcontract.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public long addCustomer(Customer customer) {
        return 0;
    }

    @Override
    public long editCustomer(Customer customer) {
        return 0;
    }

    @Override
    public long deleteCustomer(Customer customer) {
        return 0;
    }
}
