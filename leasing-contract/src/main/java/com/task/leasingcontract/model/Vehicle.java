package com.task.leasingcontract.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String brand;
    private String model;
    private String modelYear;
    private String vehicleIdentificationNumber;
    private double price;

    @OneToOne(mappedBy = "vehicle")
    private LeasingContract leasingContract;
}
