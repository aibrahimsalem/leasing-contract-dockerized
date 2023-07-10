package com.task.leasingcontract.service.impl;

import com.task.leasingcontract.model.Customer;
import com.task.leasingcontract.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void addCustomer_shouldSaveCustomer() {
        Customer customer = new Customer();
        when(customerRepository.save(customer)).thenReturn(customer);

        Customer savedCustomer = customerService.addCustomer(customer);

        assertNotNull(savedCustomer);
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void editCustomer_shouldUpdateExistingCustomer() {
        Customer existingCustomer = new Customer();
        existingCustomer.setId(1L);
        existingCustomer.setFirstname("Ahmed");
        existingCustomer.setLastname("Ibrahim");

        Customer updatedCustomer = new Customer();
        updatedCustomer.setId(1L);
        updatedCustomer.setFirstname("Khaled");
        updatedCustomer.setLastname("Ibrahim");

        when(customerRepository.findById(existingCustomer.getId())).thenReturn(Optional.of(existingCustomer));
        when(customerRepository.save(any(Customer.class))).thenReturn(updatedCustomer);

        Customer editedCustomer = customerService.editCustomer(updatedCustomer);

        assertNotNull(editedCustomer);
        assertEquals(updatedCustomer.getFirstname(), editedCustomer.getFirstname());
        assertEquals(updatedCustomer.getLastname(), editedCustomer.getLastname());
        verify(customerRepository, times(1)).findById(existingCustomer.getId());
        verify(customerRepository, times(1)).save(existingCustomer);
    }

    @Test
    void editCustomer_shouldCreateNewCustomerIfNotExists() {
        Customer newCustomer = new Customer();
        newCustomer.setId(2L);
        newCustomer.setFirstname("Ahmed");
        newCustomer.setLastname("Ibrahim");


        when(customerRepository.findById(newCustomer.getId())).thenReturn(Optional.empty());
        when(customerRepository.save(any(Customer.class))).thenReturn(newCustomer);

        Customer createdCustomer = customerService.editCustomer(newCustomer);

        assertNotNull(createdCustomer);
        assertEquals(newCustomer.getFirstname(), createdCustomer.getFirstname());
        assertEquals(newCustomer.getLastname(), createdCustomer.getLastname());
        verify(customerRepository, times(1)).findById(newCustomer.getId());
        verify(customerRepository, times(1)).save(newCustomer);
    }

    @Test
    void deleteCustomer_shouldDeleteCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);

        customerService.deleteCustomer(customer);

        verify(customerRepository, times(1)).delete(customer);
    }

    @Test
    void findCustomerById_shouldReturnExistingCustomer() {
        Customer existingCustomer = new Customer();
        existingCustomer.setId(1L);

        when(customerRepository.findById(existingCustomer.getId())).thenReturn(Optional.of(existingCustomer));

        Customer foundCustomer = customerService.findCustomerById(Long.toString(existingCustomer.getId()));

        assertNotNull(foundCustomer);
        assertEquals(existingCustomer.getId(), foundCustomer.getId());
        verify(customerRepository, times(1)).findById(existingCustomer.getId());
    }

    @Test
    void findCustomerById_shouldReturnNullIfCustomerNotFound() {
        when(customerRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        Customer foundCustomer = customerService.findCustomerById("999");

        assertNull(foundCustomer);
        verify(customerRepository, times(1)).findById(999L);
    }

    @Test
    void findAllCustomers_shouldReturnAllCustomers() {
        Customer customer1 = new Customer();
        customer1.setId(1L);
        Customer customer2 = new Customer();
        customer2.setId(2L);
        List<Customer> customers = List.of(customer1, customer2);

        when(customerRepository.findAll()).thenReturn(customers);

        List<Customer> foundCustomers = customerService.findAllCustomers();

        assertEquals(customers.size(), foundCustomers.size());
        assertEquals(customers.get(0).getId(), foundCustomers.get(0).getId());
        assertEquals(customers.get(1).getId(), foundCustomers.get(1).getId());
        verify(customerRepository, times(1)).findAll();
    }
}
