package com.hcmute.bookingve.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Vehicle")
public class Vehicle implements Serializable {

    @Column(name = "VehicleId")
    @OneToMany(mappedBy = "Bus",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Bus> buses;

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
