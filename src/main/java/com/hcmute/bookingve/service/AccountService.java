package com.hcmute.bookingve.service;

import com.hcmute.bookingve.Models.Account;

import java.util.List;
public interface AccountService {
    List<Account> findAll();
    Account findUserById(String username, String password);
}