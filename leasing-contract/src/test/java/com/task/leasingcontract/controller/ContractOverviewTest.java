package com.task.leasingcontract.controller;

import com.task.leasingcontract.dto.OverviewDto;
import com.task.leasingcontract.service.OverviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ContractOverviewTest {

    private MockMvc mockMvc;

    @Mock
    private OverviewService overviewService;

    @InjectMocks
    private ContractOverview contractOverview;

    @BeforeEach
    public void setup() {
        //MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(contractOverview).build();
    }

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
    public void testGetContractOverview() throws Exception {
        // Mock data
        OverviewDtoImpl overviewDto = new OverviewDtoImpl();
        overviewDto.setFirstname("ahmed");
        overviewDto.setLastname("ibrahim");

        when(overviewService.findLeasingContractOverview(1L)).thenReturn(overviewDto);

        // Perform the GET request
        mockMvc.perform(get("/overview/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname").value("ahmed"))
                .andExpect(jsonPath("$.lastname").value("ibrahim"));

        // Verify the service method was called
        verify(overviewService, times(1)).findLeasingContractOverview(1L);
        verifyNoMoreInteractions(overviewService);
    }

    @Test
    public void testGetAllContractsOverview() throws Exception {
        // Mock data
        OverviewDtoImpl overviewDto1 = new OverviewDtoImpl();
        overviewDto1.setFirstname("ahmed");
        overviewDto1.setLastname("ibrahim");

        // Mock data
        OverviewDtoImpl overviewDto2 = new OverviewDtoImpl();
        overviewDto2.setFirstname("khaled");
        overviewDto2.setLastname("ibrahim");

        List<OverviewDto> overviewDtoList = Arrays.asList(overviewDto1, overviewDto2);

        when(overviewService.findAllLeasingContractOverview()).thenReturn(overviewDtoList);

        // Perform the GET request
        mockMvc.perform(get("/overview"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstname").value("ahmed"))
                .andExpect(jsonPath("$[0].lastname").value("ibrahim"))
                .andExpect(jsonPath("$[1].firstname").value("khaled"))
                .andExpect(jsonPath("$[1].lastname").value("ibrahim"));

        // Verify the service method was called
        verify(overviewService, times(1)).findAllLeasingContractOverview();
        verifyNoMoreInteractions(overviewService);
    }
}