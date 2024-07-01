package com.hcmute.bookingve.service.Impl;

import com.hcmute.bookingve.Models.Partner;
import com.hcmute.bookingve.Repository.PartnerRepository;
import com.hcmute.bookingve.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PartnerServiceImpl implements PartnerService {
    @Autowired
    PartnerRepository partnerRepository;
    @Override
    public List<Partner> findAll() {
        return partnerRepository.findAll();
    }
}
