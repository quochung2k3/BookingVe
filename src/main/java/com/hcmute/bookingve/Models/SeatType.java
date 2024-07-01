package com.hcmute.bookingve.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@Getter
@Setter
@Entity
@Table(name = "SeatType")
public class SeatType implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SeatTypeId;
    private String SeatTypeName;
    private int Price;

    public SeatType(int seatTypeId, String seatTypeName, int price) {
        SeatTypeId = seatTypeId;
        SeatTypeName = seatTypeName;
        Price = price;
    }

    public SeatType() {

    }
}
