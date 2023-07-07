package com.task.leasingcontract.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contract")
public class ContractOverview {
    
    @GetMapping
    public String getDetails() {
        return "Details";
    }

}
