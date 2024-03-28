package com.hcmute.bookingve.Controller.Admin;

import com.hcmute.bookingve.Models.*;
import com.hcmute.bookingve.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    SeatService seatService;
    @RequestMapping("/")
    public String home() {
        List<Seat> seats = seatService.findAll();
        Seat seat = seats.getFirst();

        int InvoiceId = seat.getSeatId();
        String TotalSeat = seat.getSeatName();
//        int ListSeatId = pickUpAndDropOff.getPlaceId();

        System.out.println("Account ID: " + InvoiceId);
        System.out.println("Account Name: " + TotalSeat);
//        System.out.println("Account Name: " + ListSeatId);
        return "user/index";
    }
}