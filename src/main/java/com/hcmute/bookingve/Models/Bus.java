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
