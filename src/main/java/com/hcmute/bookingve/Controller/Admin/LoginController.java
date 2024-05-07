package com.hcmute.bookingve.Controller.Admin;

import com.hcmute.bookingve.Models.Account;
import com.hcmute.bookingve.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    AccountService accountService;
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/loginProccess")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Account account = accountService.findUserById(username, password);
        if(account == null) {
            return "redirect:/login";
        }
        if(account.getRoleId() == 4 && account.getIsActive()) {
            return "redirect:/";
        }
        else {
            return "redirect:/login";
        }
    }
}