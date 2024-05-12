package com.hcmute.bookingve.Repository;

import com.hcmute.bookingve.Models.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Integer> {
    @Query("SELECT vc FROM Voucher vc WHERE vc.VoucherId = :id")
    Voucher findVoucherById(int id);
    @Query("SELECT vc FROM Voucher vc")
    List<Voucher> findAll();
}