package com.task.leasingcontract.service;

import com.task.leasingcontract.model.Customer;

public interface CustomerService {

    long addCustomer(Customer customer);
    long editCustomer(Customer customer);
    long deleteCustomer(Customer customer);
}
