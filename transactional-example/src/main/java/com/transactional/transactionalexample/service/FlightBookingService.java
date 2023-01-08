package com.transactional.transactionalexample.service;

import com.transactional.transactionalexample.dto.BookingAcknowledgment;
import com.transactional.transactionalexample.dto.FlightBookingRequest;
import com.transactional.transactionalexample.entity.PassengerInfo;
import com.transactional.transactionalexample.entity.PaymentInfo;
import com.transactional.transactionalexample.repository.PassengerInfoRepository;
import com.transactional.transactionalexample.repository.PaymentInfoRepository;
import com.transactional.transactionalexample.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional//(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public BookingAcknowledgment bookingAcknowledgment(FlightBookingRequest request){

        BookingAcknowledgment acknowledgment=null;
        PassengerInfo passengerInfo=request.getPassengerInfo();
        passengerInfo=passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo=request.getPaymentInfo();
        PaymentUtils.validDateCreditLimit(paymentInfo.getAccountNo(),passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPassengerId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new BookingAcknowledgment("Success",passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfo);
    }
}
