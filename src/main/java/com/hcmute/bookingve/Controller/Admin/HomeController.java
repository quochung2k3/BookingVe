package com.hcmute.bookingve.Controller.Admin;

import com.hcmute.bookingve.Models.Account;
import com.hcmute.bookingve.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    AccountService accountService;
    @RequestMapping("/")
    public String home() {
        List<Account> accountModels = accountService.findAll();
        Account firstAccount = accountModels.getFirst();

        int accountId = firstAccount.getAccountId();
        String accountName = firstAccount.getUsername();
        Boolean isActive = firstAccount.getActive();

        System.out.println("Account ID: " + accountId);
        System.out.println("Account Name: " + accountName);
        System.out.println("Is Active: " + isActive);
        return "user/index";
    }
}