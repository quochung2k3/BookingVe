package com.hcmute.bookingve.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
@Setter
@Getter
@Entity
@Table(name = "Bus")
public class Bus implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BusId;
    private int VehicleId;
    private String VehicleName;
    private Timestamp GoingDateTime;
    private int SeatsOfBusId;
    @Column(insertable = false, updatable = false)
    private int BusTypeId;
    private int PlaceStartId;
    private int PlaceEndId;
    private String PlaceStartName;
    private String PlaceEndName;
    @Column(insertable = false, updatable = false)
    private int SeatTypeId;
    private Timestamp ArrivalDateTime;
    @ManyToOne
    @JoinColumn(name = "BusTypeId", referencedColumnName = "BusTypeId")
    private BusType BusType;
    @ManyToOne
    @JoinColumn(name = "SeatTypeId", referencedColumnName = "SeatTypeId")
    private SeatType SeatType;

    public Bus(int busId, int vehicleId, String vehicleName, Timestamp goingDateTime, int seatsOfBusId, int busTypeId, int placeStartId, int placeEndId, String placeStartName, String placeEndName, int seatTypeId, Timestamp arrivalDateTime) {
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
        SeatTypeId = seatTypeId;
        ArrivalDateTime = arrivalDateTime;
    }

    public Bus() {

    }
}