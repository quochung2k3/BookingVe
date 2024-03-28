package com.hcmute.bookingve.Repository;

import com.hcmute.bookingve.Models.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType, Integer> {

}
