package com.task.leasingcontract.controller;

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
    
    @PostMapping
    public @ResponseBody String addCustomer(@RequestBody CustomerDto customerDto) {
        return "customer Added successfully";
    }

    @PutMapping
    public @ResponseBody String editCustomer(@RequestBody CustomerDto customerDto) {
        return "customer Edited successfully";
    }

   @DeleteMapping
   public @ResponseBody String deleteCustomer(@RequestBody CustomerDto customerDto) {
    return "Customer deleted successfully";
   }
}
