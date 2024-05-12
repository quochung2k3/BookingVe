package com.hcmute.bookingve.service.Impl;

import com.hcmute.bookingve.Models.User;
import com.hcmute.bookingve.Repository.UserRepository;
import com.hcmute.bookingve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUserByUserId(int id){return userRepository.findUserByUserId(id);}
}
