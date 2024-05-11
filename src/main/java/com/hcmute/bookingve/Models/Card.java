package com.hcmute.bookingve.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@Setter
@Getter
@Entity
@Table(name = "Card")
public class Card implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CardId;
    private String CardName;
    private String CardNumber;
    private String ExpirationDate;
    private String CVV;
    private int Total;

    public Card(int cardId, String cardName, String cardNumber, String expirationDate, String CVV, int total) {
        CardId = cardId;
        CardName = cardName;
        CardNumber = cardNumber;
        ExpirationDate = expirationDate;
        this.CVV = CVV;
        Total = total;
    }

    public Card() {

    }
}