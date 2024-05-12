package com.hcmute.bookingve.Controller.User;

import com.hcmute.bookingve.Models.Bus;
import com.hcmute.bookingve.Models.Partner;
import com.hcmute.bookingve.Models.Place;
import com.hcmute.bookingve.Models.User;
import com.hcmute.bookingve.service.BusService;
import com.hcmute.bookingve.service.PartnerService;
import com.hcmute.bookingve.service.PlaceService;

import com.hcmute.bookingve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;

@Controller
public class BookingController {
    @Autowired
    PlaceService placeService;
    @Autowired
    BusService busService;
    @Autowired
    PartnerService partnerService;
    @Autowired
    UserService userService;
    @RequestMapping("/bookingPage")
    public String bookingPage(Model model,
                              @RequestParam("placeStartName") String placeStartName,
                              @RequestParam("placeEndName") String placeEndName,
                              @RequestParam("goingDate") String goingDate) {
        List<Place> places = placeService.findAll();
        List<Bus> busList = busService.findAllByStartAndEnd(placeStartName, placeEndName, goingDate);
        List<Partner> partners = partnerService.findAllExcept();
        System.out.println(placeStartName);
        System.out.println(placeEndName);
        System.out.println(goingDate);
        model.addAttribute("placeStart", placeStartName);
        model.addAttribute("placeEnd", placeEndName);
        model.addAttribute("goingDate", goingDate);
        model.addAttribute("places", places);
        model.addAttribute("busList", busList);
        model.addAttribute("partners", partners);
        return "user/bookingpage";
    }
}