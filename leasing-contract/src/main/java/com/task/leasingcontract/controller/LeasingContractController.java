package com.task.leasingcontract.controller;

import com.task.leasingcontract.dto.LeasingContractDto;
import com.task.leasingcontract.facade.LeasingContractFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contract")
public class LeasingContractController {


    @Autowired
    private LeasingContractFacade leasingContractFacade;

    @PostMapping
    public @ResponseBody LeasingContractDto addLeasingContract(@RequestBody LeasingContractDto leasingContractDto) {
        return leasingContractFacade.addLeasingContract(leasingContractDto);
    }

    @PutMapping
    public @ResponseBody LeasingContractDto editLeasingContract(@RequestBody LeasingContractDto leasingContractDto) {
        return leasingContractFacade.editLeasingContract(leasingContractDto);
    }

    @DeleteMapping
    public @ResponseBody String deleteLeasingContract(@RequestBody LeasingContractDto leasingContractDto) {
        leasingContractFacade.deleteLeasingContract(leasingContractDto);
        return "Leasing contract " + leasingContractDto.getContractNumber() + " deleted successfully";
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody LeasingContractDto findLeasingContractById(@PathVariable String id) {
        return leasingContractFacade.findLeasingContractById(id);
    }

    @GetMapping
    public List<LeasingContractDto> findAllLeasingContracts() {
        return leasingContractFacade.findAllLeasingContracts();
    }
}
