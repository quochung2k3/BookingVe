package com.hcmute.bookingve.service.Impl;

import com.hcmute.bookingve.Models.Seat;
import com.hcmute.bookingve.Repository.SeatRepository;
import com.hcmute.bookingve.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    SeatRepository seatRepository;
    @Override
    public List<Seat> findAll() {
        return seatRepository.findAll();
    }
}