package com.hcmute.bookingve.service.Impl;

import com.hcmute.bookingve.Models.SeatsOfBus;
import com.hcmute.bookingve.Repository.SeatsOfBusRepository;
import com.hcmute.bookingve.service.SeatsOfBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeatsOfBusServiceImpl implements SeatsOfBusService {
    @Autowired
    SeatsOfBusRepository seatsOfBusRepository;
    @Override
    public List<SeatsOfBus> findAll() {
        return seatsOfBusRepository.findAll();
    }
}
