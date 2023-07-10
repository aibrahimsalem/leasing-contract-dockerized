package com.task.leasingcontract.facade;

import com.task.leasingcontract.dto.LeasingContractDto;
import com.task.leasingcontract.mapper.LeasingContractSourceDestinationMapper;
import com.task.leasingcontract.model.LeasingContract;
import com.task.leasingcontract.service.LeasingContractService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LeasingContractFacadeTest {

    @Mock
    private LeasingContractSourceDestinationMapper mapper;

    @Mock
    private LeasingContractService leasingContractService;

    @InjectMocks
    private LeasingContractFacade leasingContractFacade;


    @Test
    public void testAddLeasingContract() {
        // Mock data
        LeasingContractDto leasingContractDto = new LeasingContractDto();
        leasingContractDto.setContractNumber("123L");

        LeasingContract leasingContract = new LeasingContract();
        leasingContract.setContractNumber(123L);

        when(mapper.mapLeasingContractDtoToLeasingContract(leasingContractDto)).thenReturn(leasingContract);
        when(leasingContractService.addLeasingContract(leasingContract)).thenReturn(leasingContract);
        when(mapper.mapLeasingContractToLeasingContractDto(leasingContract)).thenReturn(leasingContractDto);

        // Call the method
        LeasingContractDto result = leasingContractFacade.addLeasingContract(leasingContractDto);

        // Verify the mapper and service method were called correctly
        verify(mapper, times(1)).mapLeasingContractDtoToLeasingContract(leasingContractDto);
        verify(leasingContractService, times(1)).addLeasingContract(leasingContract);
        verify(mapper, times(1)).mapLeasingContractToLeasingContractDto(leasingContract);

        // Verify the result
        assertEquals(leasingContractDto, result);
    }

    @Test
    public void testEditLeasingContract() {
        // Mock data
        LeasingContractDto leasingContractDto = new LeasingContractDto();
        leasingContractDto.setContractNumber("123L");

        LeasingContract leasingContract = new LeasingContract();
        leasingContract.setContractNumber(123L);

        when(mapper.mapLeasingContractDtoToLeasingContract(leasingContractDto)).thenReturn(leasingContract);
        when(leasingContractService.editLeasingContract(leasingContract)).thenReturn(leasingContract);
        when(mapper.mapLeasingContractToLeasingContractDto(leasingContract)).thenReturn(leasingContractDto);

        // Call the method
        LeasingContractDto result = leasingContractFacade.editLeasingContract(leasingContractDto);

        // Verify the mapper and service method were called correctly
        verify(mapper, times(1)).mapLeasingContractDtoToLeasingContract(leasingContractDto);
        verify(leasingContractService, times(1)).editLeasingContract(leasingContract);
        verify(mapper, times(1)).mapLeasingContractToLeasingContractDto(leasingContract);

        // Verify the result
        assertEquals(leasingContractDto, result);
    }

    @Test
    public void testDeleteLeasingContract() {
        // Mock data
        LeasingContractDto leasingContractDto = new LeasingContractDto();
        leasingContractDto.setContractNumber("123L");

        LeasingContract leasingContract = new LeasingContract();
        leasingContract.setContractNumber(123L);

        when(mapper.mapLeasingContractDtoToLeasingContract(leasingContractDto)).thenReturn(leasingContract);

        // Call the method
        leasingContractFacade.deleteLeasingContract(leasingContractDto);

        // Verify the mapper and service method were called correctly
        verify(mapper, times(1)).mapLeasingContractDtoToLeasingContract(leasingContractDto);
        verify(leasingContractService, times(1)).deleteLeasingContract(leasingContract);
    }

    @Test
    public void testFindLeasingContractById() {
        // Mock data
        LeasingContractDto leasingContractDto = new LeasingContractDto();
        leasingContractDto.setContractNumber("123L");

        LeasingContract leasingContract = new LeasingContract();
        leasingContract.setContractNumber(123L);

        when(leasingContractService.findLeasingContractById("1")).thenReturn(leasingContract);
        when(mapper.mapLeasingContractToLeasingContractDto(leasingContract)).thenReturn(leasingContractDto);

        // Call the method
        LeasingContractDto result = leasingContractFacade.findLeasingContractById("1");

        // Verify the service method and mapper were called correctly
        verify(leasingContractService, times(1)).findLeasingContractById("1");
        verify(mapper, times(1)).mapLeasingContractToLeasingContractDto(leasingContract);

        // Verify the result
        assertEquals(leasingContractDto, result);
    }

    @Test
    public void testFindAllLeasingContracts() {
        // Mock data
        LeasingContract leasingContract1 = new LeasingContract();
        leasingContract1.setContractNumber(123L);

        LeasingContract leasingContract2 = new LeasingContract();
        leasingContract2.setContractNumber(123L);

        List<LeasingContract> leasingContractList = Arrays.asList(leasingContract1, leasingContract2);

        LeasingContractDto leasingContractDto1 = new LeasingContractDto();
        leasingContractDto1.setContractNumber("123L");

        LeasingContractDto leasingContractDto2 = new LeasingContractDto();
        leasingContractDto2.setContractNumber("123L");

        List<LeasingContractDto> leasingContractDtoList = Arrays.asList(leasingContractDto1, leasingContractDto2);

        when(leasingContractService.findAllLeasingContracts()).thenReturn(leasingContractList);
        when(mapper.mapLeasingContractToLeasingContractDto(leasingContract1)).thenReturn(leasingContractDto1);
        when(mapper.mapLeasingContractToLeasingContractDto(leasingContract2)).thenReturn(leasingContractDto2);

        // Call the method
        List<LeasingContractDto> result = leasingContractFacade.findAllLeasingContracts();

        // Verify the service method and mapper were called correctly
        verify(leasingContractService, times(1)).findAllLeasingContracts();
        verify(mapper, times(1)).mapLeasingContractToLeasingContractDto(leasingContract1);
        verify(mapper, times(1)).mapLeasingContractToLeasingContractDto(leasingContract2);

        // Verify the result
        assertEquals(leasingContractDtoList, result);
    }
}
