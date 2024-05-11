package com.hcmute.bookingve.Controller.User;

import com.hcmute.bookingve.Models.*;
import com.hcmute.bookingve.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PayController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    BusService busService;
    @Autowired
    BusTypeService busTypeService;
    @Autowired
    PickUpAndDropOffService pickUpAndDropOffService;
    @Autowired
    VoucherService voucherService;
    @Autowired
    CardService cardService;
    @Autowired
    InvoiceService invoiceService;
    @GetMapping("/payPage")
    public String payPage(Model model,
                          @RequestParam("busId") int busId,
                          @RequestParam("pickUpId") int pickUpId,
                          @RequestParam("dropOffId") int dropOffId,
                          @RequestParam("userName") String userName,
                          @RequestParam("sdt") String sdt,
                          @RequestParam("userEmail") String userEmail,
                          @RequestParam("totalCost") String totalCost,
                          @RequestParam("listSeatName") String listSeatName,
                          @RequestParam("listSeatId") String listSeatId) {
        Reservation reservation = new Reservation();
        reservation.setBusId(busId);
        reservation.setPickUpId(pickUpId);
        reservation.setDropOffId(dropOffId);
        reservation.setUserName(userName);
        reservation.setSDT(sdt);
        reservation.setUserEmail(userEmail);
        reservation.setIsConfirmed(true);
        reservationService.saveAs(reservation);

        // Lấy thông tin của chuyến đi theo busId
        Bus bus = busService.findById(busId);

        // Lấy thông tin loại xe theo busId
        BusType busType = busTypeService.findById(bus.getBusTypeId());

        PickUpAndDropOff pickUpModel = pickUpAndDropOffService.findById(pickUpId);
        PickUpAndDropOff dropOffModel = pickUpAndDropOffService.findById(dropOffId);

        model.addAttribute("bus", bus);
        model.addAttribute("busType", busType);
        model.addAttribute("pickUpModel", pickUpModel);
        model.addAttribute("dropOffModel", dropOffModel);
        model.addAttribute("userEmail", userEmail);
        model.addAttribute("sdt", sdt);
        model.addAttribute("userName", userName);
        model.addAttribute("totalCost", totalCost);
        model.addAttribute("listSeatName", listSeatName);
        model.addAttribute("listSeatId", listSeatId);
        return "user/pay";
    }

    @PostMapping("/checkVoucher")
    @ResponseBody
    public Map<String, Object> checkVoucher(@RequestParam("couponCode") int couponCode,
                                            @RequestParam("totalCost") String totalCost) {
        Map<String, Object> responseData = new HashMap<>();
        Voucher voucher = voucherService.findById(couponCode);
        if (voucher == null || voucher.getQuantity() == 0) {
            responseData.put("discount", "Voucher Not Found");
            responseData.put("totalAfterDiscount", totalCost);
        }
        else {
            int total = Integer.parseInt(totalCost.replace(" VNĐ", ""));
            int totalAfterDiscount = total * (100 - voucher.getDecreasePercent()) / 100;
            int discount = (total * voucher.getDecreasePercent())/100;
            System.out.println(total);
            System.out.println(totalAfterDiscount);
            responseData.put("discount", discount + " VNĐ");
            responseData.put("totalAfterDiscount", totalAfterDiscount + " VNĐ");
        }
        return responseData;
    }

    @PostMapping("/invoice")
    @ResponseBody
    public Map<String, Object> invoice(@RequestParam("userEmail") String userEmail,
                                       @RequestParam("cardNumber") String cardNumber,
                                       @RequestParam("expirationDate") String expirationDate,
                                       @RequestParam("CVV") String CVV,
                                       @RequestParam("totalCost") String totalCost,
                                       @RequestParam("totalAfterDiscount") String totalAfterDiscount,
                                       @RequestParam("listSeatName") String listSeatName,
                                       @RequestParam("listSeatId") String listSeatId,
                                       @RequestParam("voucherCode") String voucherCode) {
        Map<String, Object> responseData = new HashMap<>();
        Card card = cardService.findByCardNumber(cardNumber);
        Reservation reservation = reservationService.findByUserName(userEmail);
        System.out.println(listSeatId);
        String count = listSeatName.replaceAll("[{}]", "");
        String[] elements = count.split(",");
        System.out.println(voucherCode);
        int totalAfter = Integer.parseInt(totalAfterDiscount.replace(" VNĐ", ""));
        int total = Integer.parseInt(totalCost.replace(" VNĐ", ""));
        if(card == null || !CVV.equals(card.getCVV()) || !expirationDate.equals(card.getExpirationDate())) {
            responseData.put("announcement", "Thẻ không hợp lệ");
        }
        else {
            if(card.getTotal() < totalAfter) {
                responseData.put("announcement", "Số tiền không đủ");
            }
            else {
                Invoice invoice = new Invoice();
                invoice.setTotalPrice(total);
                invoice.setTotalDiscount(total - totalAfter);
                invoice.setListSeatName(listSeatName);
                invoice.setListSeatId(listSeatId);
                invoice.setIsPayed(true);
                invoice.setReservationId(reservation.getReservationId());
                invoice.setTotalSeat(elements.length);
                if(total != totalAfter) {
                    invoice.setVoucherId(Integer.parseInt(voucherCode));
                }
                invoiceService.saveAs(invoice);
                responseData.put("success", true);
                responseData.put("redirectUrl", "/");
            }
        }
        return responseData;
    }
}