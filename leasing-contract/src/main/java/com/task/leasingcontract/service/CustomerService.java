package com.task.leasingcontract.service;

import com.task.leasingcontract.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer);
    Customer editCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    Customer findCustomerById(String id);

    List<Customer> findAllCustomers();
}
