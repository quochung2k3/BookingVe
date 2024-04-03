package com.hcmute.bookingve.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forgotPass")
public class ForgotPassController {
    @GetMapping
    public String forgotPass() {
        return "/forgotPass";
    }
}
