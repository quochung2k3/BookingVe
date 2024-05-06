package com.hcmute.bookingve.service;

import com.hcmute.bookingve.Models.Bus;

import java.util.List;

public interface BusService {
    List<Bus> findAll();
    List<Bus> findBus(int placeStartId, int placeEndId);
}
