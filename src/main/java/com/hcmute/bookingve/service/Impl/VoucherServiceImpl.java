package com.hcmute.bookingve.service.Impl;

import com.hcmute.bookingve.Models.Voucher;
import com.hcmute.bookingve.Repository.VoucherRepository;
import com.hcmute.bookingve.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    VoucherRepository voucherRepository;
    @Override
    public List<Voucher> findAll() {
        return voucherRepository.findAll();
    }

    @Override
    public Voucher findVoucherById(int id) {
        return voucherRepository.findVoucherById(id);
    }
}
