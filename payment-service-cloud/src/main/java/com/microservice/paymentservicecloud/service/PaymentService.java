package com.microservice.paymentservicecloud.service;


import com.microservice.paymentservicecloud.entity.Payment;
import com.microservice.paymentservicecloud.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment){
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

}
