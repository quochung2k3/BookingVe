package com.hcmute.bookingve.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "Invoice")
public class Invoice implements Serializable {
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
    private String CardNumber;

    public Invoice(int invoiceId, int totalPrice, int totalSeat, String listSeatName, Boolean isPayed, int voucherId, int totalDiscount, int reservationId, String listSeatId, String cardNumber) {
        InvoiceId = invoiceId;
        TotalPrice = totalPrice;
        TotalSeat = totalSeat;
        ListSeatName = listSeatName;
        IsPayed = isPayed;
        VoucherId = voucherId;
        TotalDiscount = totalDiscount;
        ReservationId = reservationId;
        ListSeatId = listSeatId;
        CardNumber = cardNumber;
    }

    public Invoice() {
    }
}