package com.hcmute.bookingve.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaymentController {
    @RequestMapping("/paymentPage")
    public String paymentPage() {
        return "user/paymentpage";
    }
}
