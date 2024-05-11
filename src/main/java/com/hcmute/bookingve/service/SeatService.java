package com.hcmute.bookingve.service;

import com.hcmute.bookingve.Models.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> findAll();
    List<Object[]> findSeatEmptyByBusId(int busId);
    List<Seat> findSeatBybusTypeId(int busTypeId);
}