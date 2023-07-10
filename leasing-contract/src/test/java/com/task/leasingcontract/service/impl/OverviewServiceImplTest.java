package com.task.leasingcontract.service.impl;

import com.task.leasingcontract.dto.OverviewDto;
import com.task.leasingcontract.repository.OverviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OverviewServiceImplTest {

    @Mock
    private OverviewRepository overviewRepository;
    @InjectMocks
    private OverviewServiceImpl overviewService;

    static class OverviewDtoImpl implements OverviewDto {

        private Long contractNumber;

        private String firstname;

        private String lastname;

        private String brand;

        private String model;

        private String modelYear;

        private String vehicleIdentificationNumber;

        private Double monthlyRate;

        private Double price;

        public void setContractNumber(Long contractNumber) {
            this.contractNumber = contractNumber;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public void setModelYear(String modelYear) {
            this.modelYear = modelYear;
        }

        public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
            this.vehicleIdentificationNumber = vehicleIdentificationNumber;
        }

        public void setMonthlyRate(Double monthlyRate) {
            this.monthlyRate = monthlyRate;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        @Override
        public Long getContract_Number() {
            return this.contractNumber;
        }

        @Override
        public String getFirstname() {
            return this.firstname;
        }

        @Override
        public String getLastname() {
            return this.lastname;
        }

        @Override
        public String getBrand() {
            return this.brand;
        }

        @Override
        public String getModel() {
            return this.model;
        }

        @Override
        public String getModel_Year() {
            return this.modelYear;
        }

        @Override
        public String getVehicle_Identification_Number() {
            return this.vehicleIdentificationNumber;
        }

        @Override
        public Double getMonthly_Rate() {
            return this.monthlyRate;
        }

        @Override
        public Double getPrice() {
            return this.price;
        }
    }
    @Test
    public void testFindLeasingContractOverview() {
        Long leasingContractNumber = 12345L;
        OverviewDtoImpl expectedOverviewDto = new OverviewDtoImpl();
        expectedOverviewDto.setContractNumber(leasingContractNumber);

        when(overviewRepository.findLeasingContractByContractId(leasingContractNumber))
                .thenReturn(expectedOverviewDto);

        OverviewDto actualOverviewDto = overviewService.findLeasingContractOverview(leasingContractNumber);

        assertEquals(expectedOverviewDto, actualOverviewDto);
    }

    @Test
    public void testFindAllLeasingContractOverview() {
        List<OverviewDto> expectedOverviewList = Collections.singletonList(new OverviewDtoImpl());

        when(overviewRepository.findAllLeasingContractsOverview())
                .thenReturn(expectedOverviewList);

        List<OverviewDto> actualOverviewList = overviewService.findAllLeasingContractOverview();

        assertEquals(expectedOverviewList, actualOverviewList);
    }
}
