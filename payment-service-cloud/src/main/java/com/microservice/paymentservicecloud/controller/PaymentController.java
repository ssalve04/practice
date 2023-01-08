package com.microservice.paymentservicecloud.controller;


import com.microservice.paymentservicecloud.entity.Payment;
import com.microservice.paymentservicecloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/paymentRequest")
    public Payment doPayment(@RequestBody Payment payment){
        return paymentService.doPayment(payment);
    }

    public String paymentProcessin(){
        //api should be third party gateway
      return   new Random().nextBoolean()?"success":"false";
    }
}
