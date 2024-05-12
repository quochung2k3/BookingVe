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
    ReservationService reservationService;
    @Autowired
    BusService busService;
    @Autowired
    PickUpAndDropOffService pickUpAndDropOffService;
    @GetMapping("/DetailBooking")
    public String detailBooking(Model model,
                                @RequestParam("cardNumber") String cardNumber) {
        Invoice invoice = invoiceService.findByCardNumber(cardNumber);
        Reservation reservation = reservationService.findById(invoice.getReservationId());
        Bus bus = busService.findById(reservation.getBusId());
        String pickUpName = pickUpAndDropOffService.findPlaceNameById(reservation.getPickUpId());
        String dropOffName = pickUpAndDropOffService.findPlaceNameById(reservation.getDropOffId());
        model.addAttribute("invoice", invoice);
        model.addAttribute("reservation", reservation);
        model.addAttribute("bus", bus);
        model.addAttribute("pickUpName", pickUpName);
        model.addAttribute("dropOffName", dropOffName);
        return "user/DetailBooking";
    }
}