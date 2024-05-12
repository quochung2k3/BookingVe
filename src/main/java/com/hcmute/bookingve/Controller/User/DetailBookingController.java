package com.hcmute.bookingve.Controller.User;

import com.hcmute.bookingve.Models.Bus;
import com.hcmute.bookingve.Models.Invoice;
import com.hcmute.bookingve.Models.Reservation;
import com.hcmute.bookingve.service.BusService;
import com.hcmute.bookingve.service.InvoiceService;
import com.hcmute.bookingve.service.PickUpAndDropOffService;
import com.hcmute.bookingve.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DetailBookingController {
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    PickUpAndDropOffService pickUpAndDropOffService;
    @GetMapping("/DetailBooking")
    public String detailBooking(Model model,
                                @RequestParam("cardNumber") String cardNumber) {
        Invoice invoice = invoiceService.findByCardNumber(cardNumber);
        String pickUpName = pickUpAndDropOffService.findPlaceNameById(invoice.getReservation().getPickUpId());
        String dropOffName = pickUpAndDropOffService.findPlaceNameById(invoice.getReservation().getDropOffId());
        model.addAttribute("invoice", invoice);
        model.addAttribute("pickUpName", pickUpName);
        model.addAttribute("dropOffName", dropOffName);
        System.out.println(invoice.getReservation().getBus().getVehicle().getVehicleName());
        return "user/DetailBooking";
    }
}