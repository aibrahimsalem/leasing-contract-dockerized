package com.task.leasingcontract.controller;

import com.task.leasingcontract.dto.LeasingContractDto;
import com.task.leasingcontract.facade.LeasingContractFacade;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class LeasingContractControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LeasingContractFacade leasingContractFacade;

    @InjectMocks
    private LeasingContractController leasingContractController;

    @BeforeEach
    public void setup() {
        //MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(leasingContractController).build();
    }

    @Test
    public void testAddLeasingContract() throws Exception {
        // Mock data
        LeasingContractDto leasingContractDto = new LeasingContractDto();
        leasingContractDto.setContractNumber("ABC123");

        when(leasingContractFacade.addLeasingContract(leasingContractDto)).thenReturn(leasingContractDto);

        // Perform the POST request
        mockMvc.perform(post("/contract")
                        .contentType("application/json")
                        .content("{\"contractNumber\": \"ABC123\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.contractNumber").value("ABC123"));

        // Verify the facade method was called
        verify(leasingContractFacade, times(1)).addLeasingContract(leasingContractDto);
        verifyNoMoreInteractions(leasingContractFacade);
    }

    @Test
    public void testEditLeasingContract() throws Exception {
        // Mock data
        LeasingContractDto leasingContractDto = new LeasingContractDto();
        leasingContractDto.setContractNumber("ABC123");

        when(leasingContractFacade.editLeasingContract(leasingContractDto)).thenReturn(leasingContractDto);

        // Perform the PUT request
        mockMvc.perform(put("/contract")
                        .contentType("application/json")
                        .content("{\"contractNumber\": \"ABC123\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.contractNumber").value("ABC123"));

        // Verify the facade method was called
        verify(leasingContractFacade, times(1)).editLeasingContract(leasingContractDto);
        verifyNoMoreInteractions(leasingContractFacade);
    }

    @Test
    public void testDeleteLeasingContract() throws Exception {
        // Mock data
        LeasingContractDto leasingContractDto = new LeasingContractDto();
        leasingContractDto.setContractNumber("ABC123");

        // Perform the DELETE request
        mockMvc.perform(delete("/contract")
                        .contentType("application/json")
                        .content("{\"contractNumber\": \"ABC123\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Leasing contract ABC123 deleted successfully"));

        // Verify the facade method was called
        verify(leasingContractFacade, times(1)).deleteLeasingContract(leasingContractDto);
        verifyNoMoreInteractions(leasingContractFacade);
    }

    @Test
    public void testFindLeasingContractById() throws Exception {
        // Mock data
        LeasingContractDto leasingContractDto = new LeasingContractDto();
        leasingContractDto.setContractNumber("ABC123");

        when(leasingContractFacade.findLeasingContractById("1")).thenReturn(leasingContractDto);

        // Perform the GET request
        mockMvc.perform(get("/contract/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.contractNumber").value("ABC123"));

        // Verify the facade method was called
        verify(leasingContractFacade, times(1)).findLeasingContractById("1");
        verifyNoMoreInteractions(leasingContractFacade);
    }

    @Test
    public void testFindAllLeasingContracts() throws Exception {
        // Mock data
        LeasingContractDto leasingContractDto1 = new LeasingContractDto();
        leasingContractDto1.setContractNumber("ABC123");

        LeasingContractDto leasingContractDto2 = new LeasingContractDto();
        leasingContractDto2.setContractNumber("DEF456");

        List<LeasingContractDto> leasingContractDtoList = Arrays.asList(leasingContractDto1, leasingContractDto2);

        when(leasingContractFacade.findAllLeasingContracts()).thenReturn(leasingContractDtoList);

        // Perform the GET request
        mockMvc.perform(get("/contract"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].contractNumber").value("ABC123"))
                .andExpect(jsonPath("$[1].contractNumber").value("DEF456"));

        // Verify the facade method was called
        verify(leasingContractFacade, times(1)).findAllLeasingContracts();
        verifyNoMoreInteractions(leasingContractFacade);
    }
}
