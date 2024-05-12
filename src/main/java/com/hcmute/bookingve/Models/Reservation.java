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
    @Column(insertable = false, updatable = false)
    private int BusId;
    private int PickUpId;
    private int DropOffId;
    private Timestamp CreatedDate;
    private Boolean IsConfirmed;
    private String UserEmail;
    private String SDT;
    private String UserName;
    @OneToOne
    @JoinColumn(name = "BusId", referencedColumnName = "BusId")
    private Bus bus;

    public Reservation(int reservationId, int busId,int pickUpId, int dropOffId, Timestamp createdDate, Boolean isConfirmed, String userEmail, String sDT, String userName) {
        ReservationId = reservationId;
        BusId = busId;
        PickUpId = pickUpId;
        DropOffId = dropOffId;
        CreatedDate = createdDate;
        IsConfirmed = isConfirmed;
        UserEmail = userEmail;
        SDT = sDT;
        UserName = userName;
    }

    public Reservation() {

    }
}