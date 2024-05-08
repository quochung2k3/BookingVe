package com.hcmute.bookingve.Controller.User;

import com.hcmute.bookingve.Models.Bus;
import com.hcmute.bookingve.Models.BusType;
import com.hcmute.bookingve.Models.Seat;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class PaymentController {
    @Autowired
    BusService busService;
    @Autowired
    BusTypeService busTypeService;
    @Autowired
    SeatTypeService seatTypeService;
    @Autowired
    SeatService seatService;
    @RequestMapping("/paymentPage")
    public String paymentPage(@RequestParam("busId") int busId, Model model) {
        // Lấy thông tin của chuyến đi theo busId
        Bus bus = busService.findById(busId);

        // Lấy thông tin loại xe theo busId
        BusType busType = busTypeService.findById(bus.getBusTypeId());

        // Lấy thông tin giá theo seatTypeId
        SeatType seatType = seatTypeService.findById(bus.getSeatTypeId());

        // Lấy danh sách tất cả các ghế theo busTypeId
        List<Seat> seats = seatService.findSeatBybusTypeId(bus.getBusTypeId());
        List<Seat> seatsFirstHalf = new ArrayList<>();
        List<Seat> seatsSecondHalf = new ArrayList<>();
        int halfSize = seats.size() / 2;
        for (int i = 0; i < seats.size(); i++) {
            Seat seat = seats.get(i);
            if (i < halfSize) {
                seatsFirstHalf.add(seat);
            }
            else {
                seatsSecondHalf.add(seat);
            }
        }

        // Lấy danh sách ghế chưa có người đặt
        List<Object[]> seatList = seatService.findSeatEmptyByBusId(1);
        List<Seat> seatsEmpty = new ArrayList<>();
        for (Object[] row : seatList) {
            Seat seat = new Seat();
            seat.setSeatId((Integer) row[0]);
            seat.setSeatName((String) row[1]);
            seatsEmpty.add(seat);
        }

        // Truyền model xuống tầng frontEnd
        model.addAttribute("bus", bus);
        model.addAttribute("busType", busType);
        model.addAttribute("seatType", seatType);
        model.addAttribute("seatsFirstHalf", seatsFirstHalf);
        model.addAttribute("seatsSecondHalf", seatsSecondHalf);
        model.addAttribute("seatsEmpty", seatsEmpty);
        return "user/paymentpage";
    }
}