package com.hcmute.bookingve.Repository;

import com.hcmute.bookingve.Models.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {
    @Query("SELECT b FROM Bus b WHERE b.PlaceStartName = :placeStartName AND b.PlaceEndName = :placeEndName AND CAST(b.GoingDateTime AS date) = CAST(:goingDate AS date)")
    List<Bus> findAllByStartAndEnd(String placeStartName, String placeEndName, String goingDate);

}