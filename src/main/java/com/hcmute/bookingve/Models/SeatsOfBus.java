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
@Table(name = "SeatsOfBus")
public class SeatsOfBus implements Serializable {
    @Column(name = "SeatsOfBusId")
    @OneToMany(mappedBy = "Bus",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Bus> buses;
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
