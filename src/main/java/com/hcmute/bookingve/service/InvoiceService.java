package com.hcmute.bookingve.service;

import com.hcmute.bookingve.Models.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> findAll();
//    List<Invoice> findAllByUserId(int userId);

    void saveAs(Invoice invoice);

    Invoice findByCardNumber(String cardNumber);
}
