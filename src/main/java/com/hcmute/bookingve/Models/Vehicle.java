package com.hcmute.bookingve.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@Getter
@Setter
@Entity
@Table(name = "Vehicle")
public class Vehicle implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int VehicleId;
    private String VehicleName;

    public Vehicle(int vehicleId, String vehicleName) {
        VehicleId = vehicleId;
        VehicleName = vehicleName;
    }

    public Vehicle() {

    }
}
