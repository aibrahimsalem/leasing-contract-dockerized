package com.task.leasingcontract.mapper.impl;

import com.task.leasingcontract.dto.LeasingContractDto;
import com.task.leasingcontract.mapper.LeasingContractSourceDestinationMapper;
import com.task.leasingcontract.model.Customer;
import com.task.leasingcontract.model.LeasingContract;
import com.task.leasingcontract.model.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeasingContractSourceDestinationMapperImplTest {

    private LeasingContractSourceDestinationMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = new LeasingContractSourceDestinationMapperImpl();
    }

    @Test
    public void testMapLeasingContractToLeasingContractDto() {
        // Given
        LeasingContract leasingContract = new LeasingContract();
        leasingContract.setContractNumber(123456L);
        leasingContract.setId(1L);
        Customer customer = new Customer();
        customer.setId(2L);
        leasingContract.setCustomer(customer);
        leasingContract.setMonthlyRate(1000.0);
        Vehicle vehicle = new Vehicle();
        vehicle.setId(3L);
        leasingContract.setVehicle(vehicle);

        // When
        LeasingContractDto leasingContractDto = mapper.mapLeasingContractToLeasingContractDto(leasingContract);

        // Then
        Assertions.assertEquals("123456", leasingContractDto.getContractNumber());
        Assertions.assertEquals("1", leasingContractDto.getId());
        Assertions.assertEquals("2", leasingContractDto.getCustomerId());
        Assertions.assertEquals("1000.0", leasingContractDto.getMonthlyRate());
        Assertions.assertEquals("3", leasingContractDto.getVehicleId());
    }

    @Test
    public void testMapLeasingContractDtoToLeasingContract() {
        // Given
        LeasingContractDto leasingContractDto = new LeasingContractDto();
        leasingContractDto.setContractNumber("123456");
        leasingContractDto.setId("1");
        leasingContractDto.setCustomerId("2");
        leasingContractDto.setMonthlyRate("1000.0");
        leasingContractDto.setVehicleId("3");

        // When
        LeasingContract leasingContract = mapper.mapLeasingContractDtoToLeasingContract(leasingContractDto);

        // Then
        Assertions.assertEquals(123456L, leasingContract.getContractNumber());
        Assertions.assertEquals(1L, leasingContract.getId());
        Assertions.assertEquals(2L, leasingContract.getCustomer().getId());
        Assertions.assertEquals(1000.0, leasingContract.getMonthlyRate());
        Assertions.assertEquals(3L, leasingContract.getVehicle().getId());
    }
}
