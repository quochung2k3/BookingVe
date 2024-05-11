package com.hcmute.bookingve.service.Impl;

import com.hcmute.bookingve.Models.Card;
import com.hcmute.bookingve.Repository.CardRepository;
import com.hcmute.bookingve.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepository cardRepository;
    @Override
    public Card findByCardNumber(String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber);
    }
}
