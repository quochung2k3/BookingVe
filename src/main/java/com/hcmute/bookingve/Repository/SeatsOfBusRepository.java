package com.hcmute.bookingve.Repository;

import com.hcmute.bookingve.Models.SeatsOfBus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatsOfBusRepository extends JpaRepository<SeatsOfBus, Integer> {

}
