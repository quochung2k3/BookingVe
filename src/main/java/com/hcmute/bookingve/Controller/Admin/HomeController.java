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
    PlaceService placeService;
    @RequestMapping("/")
    public String home() {
        List<Place> places = placeService.findAll();
        Place place = places.getFirst();

        int InvoiceId = place.getPlaceId();
        String TotalSeat = place.getPlaceName();
//        int ListSeatId = pickUpAndDropOff.getPlaceId();

        System.out.println("Account ID: " + InvoiceId);
        System.out.println("Account Name: " + TotalSeat);
//        System.out.println("Account Name: " + ListSeatId);
        return "user/index";
    }
}