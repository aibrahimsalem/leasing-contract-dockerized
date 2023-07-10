package com.task.leasingcontract.controller;

import com.task.leasingcontract.facade.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.task.leasingcontract.dto.CustomerDto;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerFacade customerFacade;
    @PostMapping
    public @ResponseBody CustomerDto addCustomer(@RequestBody CustomerDto customerDto) {
        return customerFacade.addCustomer(customerDto);
    }
    @PutMapping
    public @ResponseBody CustomerDto editCustomer(@RequestBody CustomerDto customerDto) {
        return customerFacade.editCustomer(customerDto);
    }

   @DeleteMapping
   public @ResponseBody String deleteCustomer(@RequestBody CustomerDto customerDto) {
        customerFacade.deleteCustomer(customerDto);
    return "Customer " +customerDto.getId()+ " deleted successfully";
   }

   @GetMapping(path = "/{id}")
    public @ResponseBody CustomerDto findCustomerById(@PathVariable String id) {
       return customerFacade.findCustomerById(id);
   }

   @GetMapping
    public List<CustomerDto> findAllCustomers() {
        return customerFacade.findAllCustomers();
   }
}
