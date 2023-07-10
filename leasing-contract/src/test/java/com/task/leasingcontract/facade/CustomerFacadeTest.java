package com.task.leasingcontract.facade;

import com.task.leasingcontract.dto.CustomerDto;
import com.task.leasingcontract.mapper.CustomerSourceDestinationMapper;
import com.task.leasingcontract.model.Customer;
import com.task.leasingcontract.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CustomerFacadeTest {

    @Mock
    private CustomerSourceDestinationMapper customerSourceDestinationMapper;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerFacade customerFacade;

    @Test
    public void testAddCustomer() {
        // Mock data
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(String.valueOf(1L));
        customerDto.setFirstname("Ahmed Ibrahim");

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstname("Ahmed Ibrahim");

        when(customerSourceDestinationMapper.mapCustomerDtoToCustomer(customerDto)).thenReturn(customer);
        when(customerService.addCustomer(customer)).thenReturn(customer);
        when(customerSourceDestinationMapper.mapCustomerToCustomerDto(customer)).thenReturn(customerDto);

        // Call the method
        CustomerDto result = customerFacade.addCustomer(customerDto);

        // Verify the mapper and service method were called correctly
        verify(customerSourceDestinationMapper, times(1)).mapCustomerDtoToCustomer(customerDto);
        verify(customerService, times(1)).addCustomer(customer);
        verify(customerSourceDestinationMapper, times(1)).mapCustomerToCustomerDto(customer);

        // Verify the result
        assertEquals(customerDto, result);
    }

    @Test
    public void testEditCustomer() {
        // Mock data
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(String.valueOf(1L));
        customerDto.setFirstname("khaled");

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstname("khaled");

        when(customerSourceDestinationMapper.mapCustomerDtoToCustomer(customerDto)).thenReturn(customer);
        when(customerService.editCustomer(customer)).thenReturn(customer);
        when(customerSourceDestinationMapper.mapCustomerToCustomerDto(customer)).thenReturn(customerDto);

        // Call the method
        CustomerDto result = customerFacade.editCustomer(customerDto);

        // Verify the mapper and service method were called correctly
        verify(customerSourceDestinationMapper, times(1)).mapCustomerDtoToCustomer(customerDto);
        verify(customerService, times(1)).editCustomer(customer);
        verify(customerSourceDestinationMapper, times(1)).mapCustomerToCustomerDto(customer);

        // Verify the result
        assertEquals(customerDto, result);
    }

    @Test
    public void testDeleteCustomer() {
        // Mock data
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(String.valueOf(1L));
        customerDto.setLastname("ibrahim");

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setLastname("ibrahim");

        when(customerSourceDestinationMapper.mapCustomerDtoToCustomer(customerDto)).thenReturn(customer);

        // Call the method
        customerFacade.deleteCustomer(customerDto);

        // Verify the mapper and service method were called correctly
        verify(customerSourceDestinationMapper, times(1)).mapCustomerDtoToCustomer(customerDto);
        verify(customerService, times(1)).deleteCustomer(customer);
    }

    @Test
    public void testFindCustomerById() {
        // Mock data
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(String.valueOf(1L));
        customerDto.setLastname("ibrahim");

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setLastname("ibrahim");

        when(customerService.findCustomerById("1")).thenReturn(customer);
        when(customerSourceDestinationMapper.mapCustomerToCustomerDto(customer)).thenReturn(customerDto);

        // Call the method
        CustomerDto result = customerFacade.findCustomerById("1");

        // Verify the service method and mapper were called correctly
        verify(customerService, times(1)).findCustomerById("1");
        verify(customerSourceDestinationMapper, times(1)).mapCustomerToCustomerDto(customer);

        // Verify the result
        assertEquals(customerDto, result);
    }

    @Test
    public void testFindAllCustomers() {
        // Mock data
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstname("ahmed");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setFirstname("ibrahim");

        List<Customer> customerList = Arrays.asList(customer1, customer2);

        CustomerDto customerDto1 = new CustomerDto();
        customerDto1.setId(String.valueOf(1L));
        customerDto1.setLastname("ibrahim");

        CustomerDto customerDto2 = new CustomerDto();
        customerDto2.setId(String.valueOf(2L));
        customerDto2.setLastname("ibrahim");

        List<CustomerDto> customerDtoList = Arrays.asList(customerDto1, customerDto2);

        when(customerService.findAllCustomers()).thenReturn(customerList);
        when(customerSourceDestinationMapper.mapCustomerToCustomerDto(customer1)).thenReturn(customerDto1);
        when(customerSourceDestinationMapper.mapCustomerToCustomerDto(customer2)).thenReturn(customerDto2);

        // Call the method
        List<CustomerDto> result = customerFacade.findAllCustomers();

        // Verify the service method and mapper were called correctly
        verify(customerService, times(1)).findAllCustomers();
        verify(customerSourceDestinationMapper, times(1)).mapCustomerToCustomerDto(customer1);
        verify(customerSourceDestinationMapper, times(1)).mapCustomerToCustomerDto(customer2);

        // Verify the result
        assertEquals(customerDtoList, result);
    }
}
