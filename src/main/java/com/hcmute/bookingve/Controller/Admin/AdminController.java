package com.hcmute.bookingve.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @GetMapping("/abc")
    public String index() {
        return "admin/fragments/menu";
    }
}
