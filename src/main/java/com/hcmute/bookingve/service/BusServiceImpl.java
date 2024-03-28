package com.hcmute.bookingve.service;

import com.hcmute.bookingve.Models.Bus;
import com.hcmute.bookingve.Repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusServiceImpl implements BusService {
    @Autowired
    BusRepository busRepository;
    @Override
    public List<Bus> findAll() {
        return busRepository.findAll();
    }
}
