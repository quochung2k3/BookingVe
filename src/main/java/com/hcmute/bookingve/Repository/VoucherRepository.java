package com.hcmute.bookingve.Repository;

import com.hcmute.bookingve.Models.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Integer> {
    @Query("SELECT vc FROM Voucher vc")
    Voucher findVoucherById(int id);
}
