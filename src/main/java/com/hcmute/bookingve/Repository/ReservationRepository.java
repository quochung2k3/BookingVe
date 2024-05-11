package com.hcmute.bookingve.Repository;

import com.hcmute.bookingve.Models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query("SELECT rs FROM Reservation rs WHERE rs.UserEmail = :userEmail ORDER BY rs.ReservationId DESC LIMIT 1")
    Reservation findByUserName(String userEmail);
}
