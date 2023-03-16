package com.techie.api.controller;

import com.techie.api.dto.TransactionRequest;
import com.techie.api.dto.TransactionResponse;
import com.techie.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest){

        return orderService.saveOrder(transactionRequest);
    }
}
