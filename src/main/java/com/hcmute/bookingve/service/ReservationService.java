package com.hcmute.bookingve.service;

import com.hcmute.bookingve.Models.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> findAll();

    void saveAs(Reservation reservation);
}
