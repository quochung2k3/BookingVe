package com.hcmute.bookingve.service.Impl;

import com.hcmute.bookingve.Models.Reservation;
import com.hcmute.bookingve.Repository.ReservationRepository;
import com.hcmute.bookingve.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
}
