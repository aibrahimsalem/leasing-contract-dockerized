package com.task.leasingcontract.controller;

import com.task.leasingcontract.dto.CustomerDto;
import com.task.leasingcontract.facade.CustomerFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CustomerFacade customerFacade;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    public void setup() {
        //MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void testAddCustomer() throws Exception {
        // Mock data
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstname("ahmed");
        customerDto.setLastname("ibrahim");

        when(customerFacade.addCustomer(customerDto)).thenReturn(customerDto);

        // Perform the POST request
        mockMvc.perform(post("/customer")
                        .contentType("application/json")
                        .content("{\"firstname\": \"ahmed\", \"lastname\": \"ibrahim\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname").value("ahmed"))
                .andExpect(jsonPath("$.lastname").value("ibrahim"));

        // Verify the facade method was called
        verify(customerFacade, times(1)).addCustomer(customerDto);
        verifyNoMoreInteractions(customerFacade);
    }

    @Test
    public void testEditCustomer() throws Exception {
        // Mock data
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstname("khaled");
        customerDto.setLastname("ibrahim");

        when(customerFacade.editCustomer(customerDto)).thenReturn(customerDto);

        // Perform the PUT request
        mockMvc.perform(put("/customer")
                        .contentType("application/json")
                        .content("{\"firstname\": \"khaled\", \"lastname\": \"ibrahim\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname").value("khaled"))
                .andExpect(jsonPath("$.lastname").value("ibrahim"));

        // Verify the facade method was called
        verify(customerFacade, times(1)).editCustomer(customerDto);
        verifyNoMoreInteractions(customerFacade);
    }

    @Test
    public void testDeleteCustomer() throws Exception {
        // Mock data
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(String.valueOf(1L));

        // Perform the DELETE request
        mockMvc.perform(delete("/customer")
                        .contentType("application/json")
                        .content("{\"id\": 1}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Customer 1 deleted successfully"));

        // Verify the facade method was called
        verify(customerFacade, times(1)).deleteCustomer(customerDto);
        verifyNoMoreInteractions(customerFacade);
    }

    @Test
    public void testFindCustomerById() throws Exception {
        // Mock data
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(String.valueOf(1L));
        customerDto.setLastname("ibrahim");

        when(customerFacade.findCustomerById("1")).thenReturn(customerDto);

        // Perform the GET request
        mockMvc.perform(get("/customer/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.lastname").value("ibrahim"));

        // Verify the facade method was called
        verify(customerFacade, times(1)).findCustomerById("1");
        verifyNoMoreInteractions(customerFacade);
    }

    @Test
    public void testFindAllCustomers() throws Exception {
        // Mock data
        CustomerDto customerDto1 = new CustomerDto();
        customerDto1.setId(String.valueOf(1L));
        customerDto1.setFirstname("ahmed");

        CustomerDto customerDto2 = new CustomerDto();
        customerDto2.setId(String.valueOf(2L));
        customerDto2.setFirstname("khaled");

        List<CustomerDto> customerDtoList = Arrays.asList(customerDto1, customerDto2);

        when(customerFacade.findAllCustomers()).thenReturn(customerDtoList);

        // Perform the GET request
        mockMvc.perform(get("/customer"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].firstname").value("ahmed"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].firstname").value("khaled"));

        // Verify the facade method was called
        verify(customerFacade, times(1)).findAllCustomers();
        verifyNoMoreInteractions(customerFacade);
    }
}
