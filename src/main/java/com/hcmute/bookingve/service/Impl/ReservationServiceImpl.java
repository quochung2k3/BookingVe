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

    @Override
    public void saveAs(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public Reservation findByUserName(String userEmail) {
        return reservationRepository.findByUserName(userEmail);
    }

    @Override
    public Reservation findById(int reservationId) {
        return reservationRepository.findById(reservationId).get();
    }
}