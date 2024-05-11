package com.hcmute.bookingve.Controller.User;

import com.hcmute.bookingve.Models.Place;
import com.hcmute.bookingve.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    PlaceService placeService;
    @RequestMapping("/")
    public String home(Model model) {
        List<Place> places = placeService.findAll();
        model.addAttribute("places", places);
        return "user/index";
    }
}