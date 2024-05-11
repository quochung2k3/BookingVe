package com.hcmute.bookingve.Repository;

import com.hcmute.bookingve.Models.PickUpAndDropOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PickUpAndDropOffRepository extends JpaRepository<PickUpAndDropOff, Integer> {
    @Query("SELECT pu FROM PickUpAndDropOff pu WHERE pu.PlaceId = :placeStartId")
    List<PickUpAndDropOff> findByStartId(int placeStartId);

    @Query("SELECT pu FROM PickUpAndDropOff pu WHERE pu.PlaceId = :placeEndId")
    List<PickUpAndDropOff> findByEndId(int placeEndId);
}