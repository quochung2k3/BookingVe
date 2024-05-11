package com.hcmute.bookingve.service;

import com.hcmute.bookingve.Models.Voucher;

import java.util.List;

public interface VoucherService {
    List<Voucher> findAll();
    Voucher findVoucherById(int id);

    Voucher findById(int couponCode);
}
