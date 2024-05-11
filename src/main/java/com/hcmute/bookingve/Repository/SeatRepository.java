package com.hcmute.bookingve.Repository;

import com.hcmute.bookingve.Models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM get_list_seat_by_bus_id(:busId)")
    List<Object[]> findSeatEmptyByBusId(Integer busId);

    @Query("SELECT s FROM Seat s WHERE s.BusTypeId = :busTypeId")
    List<Seat> findSeatByBusTypeId(int busTypeId);
}