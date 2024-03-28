package com.hcmute.bookingve.Controller.Admin;

import com.hcmute.bookingve.Models.*;
import com.hcmute.bookingve.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @RequestMapping("/")
    public String home() {
        List<User> userServices = userService.findAll();
        User user = userServices.getFirst();

        int InvoiceId = user.getUserId();
        String TotalSeat = user.getFullName();
        String ListSeatId = user.getSDT();
        String test = user.getAddress();

        System.out.println("Account ID: " + InvoiceId);
        System.out.println("Account Name: " + TotalSeat);
        System.out.println("Account Name: " + ListSeatId);
        System.out.println("Account Name: " + test);
        return "user/index";
    }
}