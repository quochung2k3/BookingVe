package com.hcmute.bookingve.service;

import com.hcmute.bookingve.Models.Card;

public interface CardService {
    Card findByCardNumber(String cardNumber);
}
