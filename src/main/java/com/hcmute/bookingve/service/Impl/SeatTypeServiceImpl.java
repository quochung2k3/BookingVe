package com.hcmute.bookingve.service.Impl;

import com.hcmute.bookingve.Models.Seat;
import com.hcmute.bookingve.Models.SeatType;
import com.hcmute.bookingve.Repository.SeatTypeRepository;
import com.hcmute.bookingve.service.SeatService;
import com.hcmute.bookingve.service.SeatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeatTypeServiceImpl implements SeatTypeService {
    @Autowired
    SeatTypeRepository seatTypeRepository;
    @Override
    public List<SeatType> findAll() {
        return seatTypeRepository.findAll();
    }
}
