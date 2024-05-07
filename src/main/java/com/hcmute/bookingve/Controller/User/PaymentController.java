package com.hcmute.bookingve.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {
    @RequestMapping("/paymentPage")
    public String paymentPage(@RequestParam("busId") int busId) {
        System.out.println(busId);
        return "user/paymentpage";
    }
}