package com.hcmute.bookingve.Repository;

import com.hcmute.bookingve.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    @Query("SELECT c FROM Card c WHERE c.CardNumber = :cardNumber")
    Card findByCardNumber(String cardNumber);
}
