package com.hcmute.bookingve.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "Invoice")
public class Invoice implements Serializable {
    @Column(name = "InvoiceId")
    @OneToMany(mappedBy = "Voucher",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Voucher> vouchers;

    @Column(name = "InvoiceId")
    @OneToOne(mappedBy = "Invoice")
    @JsonManagedReference
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "ReservationId",nullable = false,referencedColumnName = "ReservationId")
    @JsonManagedReference
    private Reservation reservation;
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int InvoiceId;
    private int TotalPrice;
    private int TotalSeat;
    private String ListSeatName;
    private Boolean IsPayed;
    private int VoucherId;
    private int TotalDiscount;
    private int ReservationId;
    private String ListSeatId;

    public Invoice(int invoiceId, int totalPrice, int totalSeat, String listSeatName, Boolean isPayed, int voucherId, int totalDiscount, int reservationId, String listSeatId) {
        InvoiceId = invoiceId;
        TotalPrice = totalPrice;
        TotalSeat = totalSeat;
        ListSeatName = listSeatName;
        IsPayed = isPayed;
        VoucherId = voucherId;
        TotalDiscount = totalDiscount;
        ReservationId = reservationId;
        ListSeatId = listSeatId;
    }

    public Invoice() {
    }
}
