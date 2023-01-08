package com.transactional.transactionalexample.dto;

import com.transactional.transactionalexample.entity.PassengerInfo;
import com.transactional.transactionalexample.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingRequest {

    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
