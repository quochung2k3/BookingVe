package com.hcmute.bookingve.service.Impl;

import com.hcmute.bookingve.Models.Invoice;
import com.hcmute.bookingve.Repository.InvoiceRepository;
import com.hcmute.bookingve.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

//    public List<Invoice> findAllByUserId(int userId){ return invoiceRepository.findAllByUserId(userId);}
    @Override
    public void saveAs(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    @Override
    public Invoice findByCardNumber(String cardNumber) {
        return invoiceRepository.findByCardName(cardNumber);
    }
}
