package com.hcmute.bookingve.service.Impl;

import com.hcmute.bookingve.Models.Bus;
import com.hcmute.bookingve.Models.BusType;
import com.hcmute.bookingve.Repository.BusTypeRepository;
import com.hcmute.bookingve.service.BusTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusTypeServiceImpl implements BusTypeService {
    @Autowired
    BusTypeRepository busTypeRepository;
    @Override
    public List<BusType> findAll() {
        return busTypeRepository.findAll();
    }
}
