package com.task.leasingcontract.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String brand;
    private String model;
    private String modelYear;
    private String vehicleIdentificationNumber;
    private double price;

    @OneToOne(mappedBy = "vehicle")
    private LeasingContract leasingContract;
}
