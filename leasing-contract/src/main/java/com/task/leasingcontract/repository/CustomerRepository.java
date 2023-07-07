package com.task.leasingcontract.repository;

import org.springframework.data.repository.CrudRepository;

import com.task.leasingcontract.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    
}
