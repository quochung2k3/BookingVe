package com.hcmute.bookingve.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PayController {
    @GetMapping("/payPage")
    public String payPage() {
        return "user/payPage";
    }
}