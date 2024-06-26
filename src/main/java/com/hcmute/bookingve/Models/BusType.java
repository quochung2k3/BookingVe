package com.hcmute.bookingve.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "BusType")
public class BusType implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BusTypeId;
    private String BusTypeName;
    @OneToMany(mappedBy = "BusType")
    private List<Bus> buses;

    public BusType(int busTypeId, String busTypeName) {
        BusTypeId = busTypeId;
        BusTypeName = busTypeName;
    }

    public BusType() {

    }
}
