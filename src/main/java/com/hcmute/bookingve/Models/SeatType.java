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
@Table(name = "SeatType")
public class SeatType implements Serializable {
    @Column(name = "SeatTypeId")
    @OneToMany(mappedBy = "Seat",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Seat> seats;

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
