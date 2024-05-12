package com.hcmute.bookingve.service;

import com.hcmute.bookingve.Models.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> findAll();
    void saveAs(Invoice invoice);
    Invoice findByCardNumber(String cardNumber);
    List<Invoice> findAllByUserId(int userId);
}