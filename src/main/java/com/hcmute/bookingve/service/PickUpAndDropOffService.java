package com.hcmute.bookingve.service;

import com.hcmute.bookingve.Models.PickUpAndDropOff;

import java.util.List;

public interface PickUpAndDropOffService {
    List<PickUpAndDropOff> findAll();

    List<PickUpAndDropOff> findByStartId(int placeStartId);

    List<PickUpAndDropOff> findByEndId(int placeEndId);

    PickUpAndDropOff findById(int dropOffId);

    String findPlaceNameById(int dropOffId);
}
