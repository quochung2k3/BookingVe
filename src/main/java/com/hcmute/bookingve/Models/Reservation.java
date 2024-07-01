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
@Table(name = "Reservation")
public class Reservation implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ReservationId;
    private int BusId;
    private int UserId;
    private int PickUpId;
    private int DropOffId;
    private Timestamp CreatedDate;
    private Boolean IsConfirmed;

    public Reservation(int reservationId, int busId, int userId, int pickUpId, int dropOffId, Timestamp createdDate, Boolean isConfirmed) {
        ReservationId = reservationId;
        BusId = busId;
        UserId = userId;
        PickUpId = pickUpId;
        DropOffId = dropOffId;
        CreatedDate = createdDate;
        IsConfirmed = isConfirmed;
    }

    public Reservation() {

    }
}
