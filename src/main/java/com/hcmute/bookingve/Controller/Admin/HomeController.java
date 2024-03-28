package com.hcmute.bookingve.Controller.Admin;

import com.hcmute.bookingve.Models.Account;
import com.hcmute.bookingve.Models.Bus;
import com.hcmute.bookingve.Models.BusType;
import com.hcmute.bookingve.Models.Invoice;
import com.hcmute.bookingve.service.AccountService;
import com.hcmute.bookingve.service.BusService;
import com.hcmute.bookingve.service.BusTypeService;
import com.hcmute.bookingve.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    InvoiceService invoiceService;
    @RequestMapping("/")
    public String home() {
        List<Invoice> invoices = invoiceService.findAll();
        Invoice invoicesFirst = invoices.getFirst();

        int InvoiceId = invoicesFirst.getInvoiceId();
        int TotalSeat = invoicesFirst.getTotalSeat();
        String ListSeatId = invoicesFirst.getListSeatName();

        System.out.println("Account ID: " + InvoiceId);
        System.out.println("Account Name: " + TotalSeat);
        System.out.println("Account Name: " + ListSeatId);
        return "user/index";
    }
}