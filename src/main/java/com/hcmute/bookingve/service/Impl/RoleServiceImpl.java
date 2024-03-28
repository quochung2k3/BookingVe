package com.hcmute.bookingve.service.Impl;

import com.hcmute.bookingve.Models.Role;
import com.hcmute.bookingve.Repository.RoleRepository;
import com.hcmute.bookingve.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
