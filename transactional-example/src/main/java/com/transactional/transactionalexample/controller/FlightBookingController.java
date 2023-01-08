package com.transactional.transactionalexample.controller;


import com.transactional.transactionalexample.dto.BookingAcknowledgment;
import com.transactional.transactionalexample.dto.FlightBookingRequest;
import com.transactional.transactionalexample.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class FlightBookingController {

    @Autowired
    private FlightBookingService bookingService;
    @PostMapping("/bookTicket")
    public BookingAcknowledgment bookingAcknowledgment(@RequestBody FlightBookingRequest request){
        return bookingService.bookingAcknowledgment(request);
    }
}
