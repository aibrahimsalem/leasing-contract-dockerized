package com.task.leasingcontract.controller;

import com.task.leasingcontract.facade.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.leasingcontract.dto.CustomerDto;

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
}
