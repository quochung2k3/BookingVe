package com.hcmute.bookingve.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@Getter
@Setter
@Entity
@Table(name = "SeatsOfBus")
public class SeatsOfBus implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SeatsOfBusId;
    private int Quantity;

    public SeatsOfBus(int seatsOfBusId, int quantity) {
        SeatsOfBusId = seatsOfBusId;
        Quantity = quantity;
    }

    public SeatsOfBus() {

    }
}
