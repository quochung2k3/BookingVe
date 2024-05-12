package com.hcmute.bookingve.Controller.Admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/ql-account")
public class AccountController {
   @GetMapping
   public String index () {return "admin/account/ql-account";}

}
