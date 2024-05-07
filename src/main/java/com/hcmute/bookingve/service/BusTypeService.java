package com.hcmute.bookingve.service;

import com.hcmute.bookingve.Models.BusType;

import java.util.List;
import java.util.Optional;

public interface BusTypeService {
    List<BusType> findAll();

    BusType findById(int busTypeId);
}
