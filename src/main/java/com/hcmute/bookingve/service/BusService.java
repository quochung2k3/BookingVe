package com.hcmute.bookingve.service;

import com.hcmute.bookingve.Models.Bus;

import java.util.List;
import java.util.Optional;

public interface BusService {
    List<Bus> findAllByStartAndEnd(String placeStartName, String placeEndName, String goingDate);
    Bus findById(int busId);
}
