package com.hcmute.bookingve.service.Impl;

import com.hcmute.bookingve.Repository.AccountRepository;
import com.hcmute.bookingve.Models.Account;
import com.hcmute.bookingve.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findUserById(String username, String password) {
        return accountRepository.findUserById(username, password);
    }
}