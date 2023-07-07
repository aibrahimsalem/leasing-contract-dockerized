package com.task.leasingcontract.repository;

import org.springframework.data.repository.CrudRepository;

import com.task.leasingcontract.model.LeasingContract;

public interface LeasingContractRepository extends CrudRepository<LeasingContract, Long> {
    
}
