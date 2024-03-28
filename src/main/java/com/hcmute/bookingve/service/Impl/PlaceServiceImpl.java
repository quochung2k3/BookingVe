package com.hcmute.bookingve.service.Impl;

import com.hcmute.bookingve.Models.Place;
import com.hcmute.bookingve.Repository.PlaceRepository;
import com.hcmute.bookingve.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    PlaceRepository placeRepository;
    @Override
    public List<Place> findAll() {
        return placeRepository.findAll();
    }
}
