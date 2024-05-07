package com.hcmute.bookingve.service;

import com.hcmute.bookingve.Models.SeatType;

import java.util.List;

public interface SeatTypeService {
    List<SeatType> findAll();

    SeatType findById(int seatTypeId);
}
