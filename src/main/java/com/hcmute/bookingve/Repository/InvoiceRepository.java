package com.hcmute.bookingve.Repository;

import com.hcmute.bookingve.Models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    @Query("SELECT i FROM Invoice i WHERE i.CardNumber = :cardNumber ORDER BY i.InvoiceId DESC LIMIT 1")
    Invoice findByCardName(String cardNumber);
}