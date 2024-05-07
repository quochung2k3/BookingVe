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
@Table(name = "Reservation")
public class Reservation implements Serializable {
    @Column(name = "ReservationId")
    @OneToMany(mappedBy = "Invoice",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Invoice> invoices;

    @ManyToOne
    @JoinColumn(name = "UserId",nullable = false,referencedColumnName = "UserId")
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "PickUpId",nullable = false,referencedColumnName = "PickUpId")
    @JoinColumn(name = "DropOffId",nullable = false,referencedColumnName = "DropOffId")
    @JsonManagedReference
    private PickUpAndDropOff pickUpAndDropOff;

    @ManyToOne
    @JoinColumn(name = "bus_id",nullable = false,referencedColumnName = "bus_id")
    @JsonManagedReference
    private Bus bus;
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
