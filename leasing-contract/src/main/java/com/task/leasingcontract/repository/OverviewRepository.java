package com.task.leasingcontract.repository;

import com.task.leasingcontract.dto.OverviewDto;
import com.task.leasingcontract.model.LeasingContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OverviewRepository extends JpaRepository<LeasingContract, Long> {

    @Query(nativeQuery = true, value = "select contract_number, firstname, lastname, brand, model, model_year, vehicle_identification_number, monthly_rate, price from leasing_contract lc, customer c, vehicle v where lc.customer_id = c.id and lc.vehicle_id = v.id and lc.contract_number = :contractNumber")
    OverviewDto findLeasingContractByContractId(@Param("contractNumber") Long contractNumber);

    @Query(nativeQuery = true, value = "select contract_number, firstname, lastname, brand, model, model_year, vehicle_identification_number, monthly_rate, price from leasing_contract lc, customer c, vehicle v where lc.customer_id = c.id and lc.vehicle_id = v.id")
    List<OverviewDto> findAllLeasingContractsOverview();
}
