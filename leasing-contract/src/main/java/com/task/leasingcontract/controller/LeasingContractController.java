package com.task.leasingcontract.controller;

import com.task.leasingcontract.dto.CustomerDto;
import com.task.leasingcontract.dto.LeasingContractDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/contract")
public class LeasingContractController {

    @PostMapping
    public @ResponseBody String addLeasingContract(@RequestBody LeasingContractDto leasingContractDto) {
        return "Leasing contract Added successfully";
    }

    @PutMapping
    public @ResponseBody String editLeasingContract(@RequestBody LeasingContractDto leasingContractDto) {
        return "Leasing contract Edited successfully";
    }

    @DeleteMapping
    public @ResponseBody String deleteLeasingContract(@RequestBody LeasingContractDto leasingContractDto) {
        return "Leasing contract deleted successfully";
    }
}
