package com.task.leasingcontract.service.impl;

import com.task.leasingcontract.model.Customer;
import com.task.leasingcontract.repository.CustomerRepository;
import com.task.leasingcontract.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer editCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findById(customer.getId());
        if (customerOptional.isPresent()) {
            Customer storedCustomer = customerOptional.get();
            storedCustomer.setFirstname(customer.getFirstname());
            storedCustomer.setLastname(customer.getLastname());
            storedCustomer.setBirthdate(customer.getBirthdate());
            return customerRepository.save(storedCustomer);
        }
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
}
