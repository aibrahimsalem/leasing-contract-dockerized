package com.task.leasingcontract.controller;

import com.task.leasingcontract.dto.VehicleDto;
import com.task.leasingcontract.facade.VehicleFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class VehicleControllerTest {

    private MockMvc mockMvc;

    @Mock
    private VehicleFacade vehicleFacade;

    @InjectMocks
    private VehicleController vehicleController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(vehicleController).build();
    }
    
    @Test
    public void testAddVehicle() throws Exception {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId("1");
        vehicleDto.setBrand("Toyota");
        vehicleDto.setModel("Camry");

        when(vehicleFacade.addVehicle(vehicleDto)).thenReturn(vehicleDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/vehicle")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"1\",\"brand\":\"Toyota\",\"model\":\"Camry\"}"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand").value("Toyota"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.model").value("Camry"))
                .andDo(print());
    }

    @Test
    public void testEditVehicle() throws Exception {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId("1");
        vehicleDto.setBrand("Toyota");
        vehicleDto.setModel("Camry");

        when(vehicleFacade.editVehicle(vehicleDto)).thenReturn(vehicleDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/vehicle")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"1\",\"brand\":\"Toyota\",\"model\":\"Camry\"}"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand").value("Toyota"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.model").value("Camry"))
                .andDo(print());
    }

    @Test
    public void testDeleteVehicle() throws Exception {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId("1");

        mockMvc.perform(MockMvcRequestBuilders.delete("/vehicle")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"1\"}"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Vehicle 1 deleted successfully"))
                .andDo(print());
    }

    @Test
    public void testFindVehicleById() throws Exception {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId("1");
        vehicleDto.setBrand("Toyota");
        vehicleDto.setModel("Camry");

        when(vehicleFacade.findVehicleById("1")).thenReturn(vehicleDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/vehicle/{id}", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand").value("Toyota"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.model").value("Camry"))
                .andDo(print());
    }

    @Test
    public void testFindAllVehicles() throws Exception {
        VehicleDto vehicleDto1 = new VehicleDto();
        vehicleDto1.setId("1");
        vehicleDto1.setBrand("Toyota");
        vehicleDto1.setModel("Camry");

        VehicleDto vehicleDto2 = new VehicleDto();
        vehicleDto2.setId("2");
        vehicleDto2.setBrand("Honda");
        vehicleDto2.setModel("Accord");

        List<VehicleDto> vehicleList = Arrays.asList(vehicleDto1, vehicleDto2);

        when(vehicleFacade.findAllVehicles()).thenReturn(vehicleList);

        mockMvc.perform(MockMvcRequestBuilders.get("/vehicle")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].brand").value("Toyota"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].model").value("Camry"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].id").value("2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].brand").value("Honda"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].model").value("Accord"))
                .andDo(print());
    }
}
