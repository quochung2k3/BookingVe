package com.hcmute.bookingve.service;

import com.hcmute.bookingve.Models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findUserByUserId(int id);
}
