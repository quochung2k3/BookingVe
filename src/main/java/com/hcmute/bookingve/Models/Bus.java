package com.hcmute.bookingve.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "Bus")
public class Bus implements Serializable {

    @Column(name = "BusId")
    @OneToMany(mappedBy = "reservation",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Reservation> reservations;

    @ManyToOne
    @JoinColumn(name = "PlaceId",nullable = false,referencedColumnName = "PlaceId")
    @JsonManagedReference
    private Place place;

    @ManyToOne
    @JoinColumn(name = "BusId",nullable = false,referencedColumnName = "BusId")
    @JsonManagedReference
    private BusType busType;

    @ManyToOne
    @JoinColumn(name = "BusId",nullable = false,referencedColumnName = "BusId")
    @JsonManagedReference
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "BusId",nullable = false,referencedColumnName = "BusId")
    @JsonManagedReference
    private SeatsOfBus seatsOfBus;
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BusId;
    private int VehicleId;
    private String VehicleName;
    private Timestamp GoingDateTime;
    private int SeatsOfBusId;
    private int BusTypeId;
    private int PlaceStartId;
    private int PlaceEndId;
    private String PlaceStartName;
    private String PlaceEndName;

    public Bus(int busId, int vehicleId, String vehicleName, Timestamp goingDateTime, int seatsOfBusId, int busTypeId, int placeStartId, int placeEndId, String placeStartName, String placeEndName) {
        BusId = busId;
        VehicleId = vehicleId;
        VehicleName = vehicleName;
        GoingDateTime = goingDateTime;
        SeatsOfBusId = seatsOfBusId;
        BusTypeId = busTypeId;
        PlaceStartId = placeStartId;
        PlaceEndId = placeEndId;
        PlaceStartName = placeStartName;
        PlaceEndName = placeEndName;
    }

    public Bus() {

    }
}
