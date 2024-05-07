package com.hcmute.bookingve.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "Voucher")
public class Voucher implements Serializable {
    @ManyToOne
    @JoinColumn(name = "SeatId",nullable = false,referencedColumnName = "SeatId")
    @JsonManagedReference
    private Invoice invoice;
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int VoucherId;
    private String VoucherName;
    private int DecreasePercent;
    private int Quantity;
    private Date DayStart;
    private Date DayEnd;
    private Boolean IsActive;

    public Voucher(int voucherId, String voucherName, int decreasePercent, int quantity, Date dayStart, Date dayEnd, Boolean isActive) {
        VoucherId = voucherId;
        VoucherName = voucherName;
        DecreasePercent = decreasePercent;
        Quantity = quantity;
        DayStart = dayStart;
        DayEnd = dayEnd;
        IsActive = isActive;
    }

    public Voucher() {

    }
}
