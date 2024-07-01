package com.hcmute.bookingve.Repository;

import com.hcmute.bookingve.Models.BusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusTypeRepository extends JpaRepository<BusType, Integer> {

}
