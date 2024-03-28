package com.hcmute.bookingve.Repository;

import com.hcmute.bookingve.Models.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer> {

}
