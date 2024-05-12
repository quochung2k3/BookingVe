package com.hcmute.bookingve.Controller.User;

import com.hcmute.bookingve.Models.Bus;
import com.hcmute.bookingve.Models.Invoice;
import com.hcmute.bookingve.Models.Reservation;
import com.hcmute.bookingve.service.BusService;
import com.hcmute.bookingve.service.InvoiceService;
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
    @GetMapping("/DetailBooking")
    public String detailBooking(Model model,
                                @RequestParam("busName") String cardNumber) {
        Invoice invoice = invoiceService.findByCardNumber(cardNumber);
//        Reservation reservation = reservationService.findById(invoice.getReservationId());
//        Bus bus = busService.findById(reservation.getBusId());
//        model.addAttribute("invoice", invoice);
        return "user/DetailBooking";
    }
}