package com.microservice.orderservicecloud.controller;


import com.microservice.orderservicecloud.common.Payment;
import com.microservice.orderservicecloud.common.TransactionRequest;
import com.microservice.orderservicecloud.common.TransactionResponse;
import com.microservice.orderservicecloud.entity.Order;
import com.microservice.orderservicecloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping(value = "/productOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest){

        return orderService.saveOrder(transactionRequest);
    }
}
