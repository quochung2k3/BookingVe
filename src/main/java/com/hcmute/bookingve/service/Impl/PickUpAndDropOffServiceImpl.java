package com.hcmute.bookingve.service.Impl;

import com.hcmute.bookingve.Models.PickUpAndDropOff;
import com.hcmute.bookingve.Repository.PickUpAndDropOffRepository;
import com.hcmute.bookingve.service.PickUpAndDropOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PickUpAndDropOffServiceImpl implements PickUpAndDropOffService {
    @Autowired
    PickUpAndDropOffRepository pickUpAndDropOffRepository;
    @Override
    public List<PickUpAndDropOff> findAll() {
        return pickUpAndDropOffRepository.findAll();
    }

    @Override
    public List<PickUpAndDropOff> findByStartId(int placeStartId) {
        return pickUpAndDropOffRepository.findByStartId(placeStartId);
    }

    @Override
    public List<PickUpAndDropOff> findByEndId(int placeEndId) {
        return pickUpAndDropOffRepository.findByEndId(placeEndId);
    }
}
