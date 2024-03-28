package com.hcmute.bookingve.service.Impl;

import com.hcmute.bookingve.Models.Vehicle;
import com.hcmute.bookingve.Repository.VehicleRepository;
import com.hcmute.bookingve.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;
    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }
}
