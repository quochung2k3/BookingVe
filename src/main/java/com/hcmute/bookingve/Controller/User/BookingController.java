package com.hcmute.bookingve.Controller.User;

import com.hcmute.bookingve.Models.Bus;
import com.hcmute.bookingve.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class BookingController {
    @Autowired
    BusService busService;
    @RequestMapping("/bookingPage")
    public String bookingPage(Model model) {
        List<Bus> busList = busService.findAll();
        model.addAttribute("busList", busList);
        return "user/bookingPage";
    }
}
