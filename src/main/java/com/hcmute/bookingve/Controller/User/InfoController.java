package com.hcmute.bookingve.Controller.User;

import com.hcmute.bookingve.Models.Invoice;
import com.hcmute.bookingve.Models.User;
import com.hcmute.bookingve.Models.Voucher;
import com.hcmute.bookingve.service.InvoiceService;
import com.hcmute.bookingve.service.UserService;
import com.hcmute.bookingve.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class InfoController {
    @Autowired
    UserService userService;
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    VoucherService voucherService;
    @RequestMapping("/info")
    public String infoPage(Model model,
                           @RequestParam("userId") int userId){
        User user = userService.findUserByUserId(userId);
        model.addAttribute("user",user);
        return "user/info";
    }

    @RequestMapping("/history")
    public String historyPage(Model model,
                              @RequestParam("userId") int userId){
//        List<Invoice> invoiceList = invoiceService.findAllByUserId(userId);
        User user = userService.findUserByUserId(userId);
        model.addAttribute("user",user);
//        model.addAttribute("invoices",invoiceList);
        return "user/history_view";
    }

    @RequestMapping("/voucher")
    public String voucherPage(Model model,
                              @RequestParam("userId")int userId){
        List<Voucher> voucherList = voucherService.findAll();
        model.addAttribute("vouchers", voucherList);
        User user = userService.findUserByUserId(userId);
        model.addAttribute("user",user);
        return "user/voucher_view";
    }
}