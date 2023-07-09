package com.task.leasingcontract.controller;

import com.task.leasingcontract.dto.LeasingContractDto;
import com.task.leasingcontract.facade.LeasingContractFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/contract")
public class LeasingContractController {


    @Autowired
    private LeasingContractFacade leasingContractFacade;

    @PostMapping
    public @ResponseBody String addLeasingContract(@RequestBody LeasingContractDto leasingContractDto) {
        LeasingContractDto savedLeasingContractDto = leasingContractFacade.addLeasingContract(leasingContractDto);
        return "Leasing contract Added successfully";
    }

    @PutMapping
    public @ResponseBody String editLeasingContract(@RequestBody LeasingContractDto leasingContractDto) {
        LeasingContractDto editedLeasingContractDto = leasingContractFacade.editLeasingContract(leasingContractDto);
        return "Leasing contract Edited successfully";
    }

    @DeleteMapping
    public @ResponseBody String deleteLeasingContract(@RequestBody LeasingContractDto leasingContractDto) {
        leasingContractFacade.deleteLeasingContract(leasingContractDto);
        return "Leasing contract deleted successfully";
    }
}
