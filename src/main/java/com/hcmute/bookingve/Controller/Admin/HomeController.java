package com.hcmute.bookingve.Controller.Admin;

import com.hcmute.bookingve.Models.*;
import com.hcmute.bookingve.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    VoucherService voucherService;
    @RequestMapping("/")
    public String home() {
        List<Voucher> vouchers = voucherService.findAll();
        Voucher voucher = vouchers.getFirst();

        int InvoiceId = voucher.getVoucherId();
        String TotalSeat = voucher.getVoucherName();
        Date ListSeatId = voucher.getDayStart();
        Date test = voucher.getDayEnd();

        System.out.println("Account ID: " + InvoiceId);
        System.out.println("Account Name: " + TotalSeat);
        System.out.println("Account Name: " + ListSeatId);
        System.out.println("Account Name: " + test);
        return "user/index";
    }
}