package com.task.leasingcontract.service.impl;

import com.task.leasingcontract.model.LeasingContract;
import com.task.leasingcontract.repository.LeasingContractRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LeasingContractServiceImplTest {

    @Mock
    private LeasingContractRepository leasingContractRepository;

    @InjectMocks
    private LeasingContractServiceImpl leasingContractService;

    @Test
    void addLeasingContract_ShouldReturnSavedLeasingContract() {
        // Arrange
        LeasingContract leasingContract = new LeasingContract();
        when(leasingContractRepository.save(leasingContract)).thenReturn(leasingContract);

        // Act
        LeasingContract savedLeasingContract = leasingContractService.addLeasingContract(leasingContract);

        // Assert
        assertNotNull(savedLeasingContract);
        verify(leasingContractRepository, times(1)).save(leasingContract);
    }

    @Test
    void editLeasingContract_ExistingLeasingContract_ShouldReturnUpdatedLeasingContract() {
        // Arrange
        LeasingContract existingLeasingContract = new LeasingContract();
        existingLeasingContract.setId(1L);
        existingLeasingContract.setContractNumber(Long.valueOf("12345"));
        existingLeasingContract.setMonthlyRate(1000.0);

        LeasingContract updatedLeasingContract = new LeasingContract();
        updatedLeasingContract.setId(1L);
        updatedLeasingContract.setContractNumber(Long.valueOf("67890"));
        updatedLeasingContract.setMonthlyRate(1500.0);

        when(leasingContractRepository.findById(1L)).thenReturn(Optional.of(existingLeasingContract));
        when(leasingContractRepository.save(existingLeasingContract)).thenReturn(updatedLeasingContract);

        // Act
        LeasingContract result = leasingContractService.editLeasingContract(updatedLeasingContract);

        // Assert
        assertNotNull(result);
        assertEquals(updatedLeasingContract.getContractNumber(), result.getContractNumber());
        assertEquals(updatedLeasingContract.getMonthlyRate(), result.getMonthlyRate());
        verify(leasingContractRepository, times(1)).findById(1L);
        verify(leasingContractRepository, times(1)).save(existingLeasingContract);
    }

    @Test
    void editLeasingContract_NonExistingLeasingContract_ShouldReturnSavedLeasingContract() {
        // Arrange
        LeasingContract newLeasingContract = new LeasingContract();
        newLeasingContract.setId(1L);
        newLeasingContract.setContractNumber(Long.valueOf("12345"));
        newLeasingContract.setMonthlyRate(1000.0);

        when(leasingContractRepository.findById(1L)).thenReturn(Optional.empty());
        when(leasingContractRepository.save(newLeasingContract)).thenReturn(newLeasingContract);

        // Act
        LeasingContract result = leasingContractService.editLeasingContract(newLeasingContract);

        // Assert
        assertNotNull(result);
        assertEquals(newLeasingContract.getContractNumber(), result.getContractNumber());
        assertEquals(newLeasingContract.getMonthlyRate(), result.getMonthlyRate());
        verify(leasingContractRepository, times(1)).findById(1L);
        verify(leasingContractRepository, times(1)).save(newLeasingContract);
    }

    @Test
    void deleteLeasingContract_ShouldCallRepositoryDeleteMethod() {
        // Arrange
        LeasingContract leasingContract = new LeasingContract();

        // Act
        leasingContractService.deleteLeasingContract(leasingContract);

        // Assert
        verify(leasingContractRepository, times(1)).delete(leasingContract);
    }

    @Test
    void findLeasingContractById_ExistingId_ShouldReturnLeasingContract() {
        // Arrange
        LeasingContract leasingContract = new LeasingContract();
        leasingContract.setId(1L);

        when(leasingContractRepository.findById(1L)).thenReturn(Optional.of(leasingContract));

        // Act
        LeasingContract result = leasingContractService.findLeasingContractById("1");

        // Assert
        assertNotNull(result);
        assertEquals(leasingContract.getId(), result.getId());
        verify(leasingContractRepository, times(1)).findById(1L);
    }

    @Test
    void findLeasingContractById_NonExistingId_ShouldReturnNull() {
        // Arrange
        when(leasingContractRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        LeasingContract result = leasingContractService.findLeasingContractById("1");

        // Assert
        assertNull(result);
        verify(leasingContractRepository, times(1)).findById(1L);
    }

    @Test
    void findAllLeasingContracts_ShouldReturnAllLeasingContracts() {
        // Arrange
        List<LeasingContract> leasingContracts = new ArrayList<>();
        leasingContracts.add(new LeasingContract());
        leasingContracts.add(new LeasingContract());
        leasingContracts.add(new LeasingContract());

        when(leasingContractRepository.findAll()).thenReturn(leasingContracts);

        // Act
        List<LeasingContract> result = leasingContractService.findAllLeasingContracts();

        // Assert
        assertEquals(leasingContracts.size(), result.size());
        verify(leasingContractRepository, times(1)).findAll();
    }
}
