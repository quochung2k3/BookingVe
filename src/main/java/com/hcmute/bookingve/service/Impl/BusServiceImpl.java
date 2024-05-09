package com.hcmute.bookingve.service.Impl;

import com.hcmute.bookingve.Models.Bus;
import com.hcmute.bookingve.Repository.BusRepository;
import com.hcmute.bookingve.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {
    @Autowired
    BusRepository busRepository;
    @Override
    public List<Bus> findAllByStartAndEnd(String placeStartName, String placeEndName, String goingDate) {
        return busRepository.findAllByStartAndEnd(placeStartName, placeEndName, goingDate);
    }

    @Override
    public Bus findById(int busId) {
        return busRepository.findById(busId).get();
    }
}
