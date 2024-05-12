package com.hcmute.bookingve.Repository;

import com.hcmute.bookingve.Models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    @Query("SELECT inv FROM Invoice inv WHERE inv.UserId = :userId")
    List<Invoice> findAllByUserId(int userId);

    @Query("SELECT inv FROM Invoice inv")
    List<Invoice> findAll();
    @Query("SELECT i FROM Invoice i WHERE i.CardNumber = :cardNumber ORDER BY i.InvoiceId DESC LIMIT 1")
    Invoice findByCardName(String cardNumber);
}
