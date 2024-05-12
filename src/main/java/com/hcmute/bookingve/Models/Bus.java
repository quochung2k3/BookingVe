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
    @Column(insertable = false, updatable = false)
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
    private int TotalSeatEmpty;
    @ManyToOne
    @JoinColumn(name = "BusTypeId", referencedColumnName = "BusTypeId")
    private BusType BusType;
    @ManyToOne
    @JoinColumn(name = "SeatTypeId", referencedColumnName = "SeatTypeId")
    private SeatType SeatType;
    @ManyToOne
    @JoinColumn(name = "VehicleId", referencedColumnName = "VehicleId")
    private Vehicle vehicle;
    public Bus(int busId, int vehicleId, String vehicleName, Timestamp goingDateTime, int seatsOfBusId, int busTypeId, int placeStartId, int placeEndId, String placeStartName, String placeEndName, int seatTypeId, Timestamp arrivalDateTime, int totalSeatEmpty) {
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
        TotalSeatEmpty = totalSeatEmpty;
    }

    public Bus() {

    }
}