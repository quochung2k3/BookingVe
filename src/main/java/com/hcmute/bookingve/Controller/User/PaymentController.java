package com.hcmute.bookingve.Controller.User;

import com.hcmute.bookingve.Models.Bus;
import com.hcmute.bookingve.Models.BusType;
import com.hcmute.bookingve.Models.SeatType;
import com.hcmute.bookingve.service.BusService;
import com.hcmute.bookingve.service.BusTypeService;
import com.hcmute.bookingve.service.SeatService;
import com.hcmute.bookingve.service.SeatTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PaymentController {
    @Autowired
    BusService busService;
    @Autowired
    BusTypeService busTypeService;
    @Autowired
    SeatTypeService seatTypeService;
    @RequestMapping("/paymentPage")
    public String paymentPage(@RequestParam("busId") int busId, Model model) {
        Bus bus = busService.findById(busId);
        BusType busType = busTypeService.findById(bus.getBusTypeId());
        SeatType seatType = seatTypeService.findById(bus.getSeatTypeId());
        model.addAttribute("bus", bus);
        model.addAttribute("busType", busType);
        model.addAttribute("seatType", seatType);
        return "user/paymentpage";
    }
}