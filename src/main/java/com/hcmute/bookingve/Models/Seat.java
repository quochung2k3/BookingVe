package com.hcmute.bookingve.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@Getter
@Setter
@Entity
@Table(name = "Seat")
public class Seat implements Serializable {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="InvoiceId",referencedColumnName = "SeatId")
    @JsonManagedReference
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "SeatTypeId",nullable = false,referencedColumnName = "SeatTypeId")
    @JsonManagedReference
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name = "BusTypeId",nullable = false,referencedColumnName = "BusTypeId")
    @JsonManagedReference
    private BusType busType;
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SeatId;
    private String SeatName;
    private int BusTypeId;
    private int SeatTypeId;

    public Seat(int seatId, String seatName, int busTypeId, int seatTypeId) {
        SeatId = seatId;
        SeatName = seatName;
        BusTypeId = busTypeId;
        SeatTypeId = seatTypeId;
    }

    public Seat() {

    }
}
