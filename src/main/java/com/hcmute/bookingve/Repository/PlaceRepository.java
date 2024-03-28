package com.hcmute.bookingve.Repository;

import com.hcmute.bookingve.Models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {

}
