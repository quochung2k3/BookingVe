package com.hcmute.bookingve.Repository;

import com.hcmute.bookingve.Models.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer> {
    @Query("SELECT pn FROM Partner pn WHERE pn.PartnerId NOT IN (1, 4)")
    List<Partner> findAllExcept();
}