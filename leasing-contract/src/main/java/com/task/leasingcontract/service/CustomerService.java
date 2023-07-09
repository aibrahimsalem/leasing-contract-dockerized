package com.task.leasingcontract.service;

import com.task.leasingcontract.model.Customer;

public interface CustomerService {

    Customer addCustomer(Customer customer);
    Customer editCustomer(Customer customer);
    void deleteCustomer(Customer customer);
}
