package net.saga.controller;


import net.saga.dto.OrderRequestDto;
import net.saga.entity.PurchaseOrder;
import net.saga.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public PurchaseOrder createOrder(@RequestBody OrderRequestDto orderRequestDto){

        return orderService.createOrder(orderRequestDto);
    }

    public List<PurchaseOrder> getAllOrders(){
        return orderService.getAllOrders();
    }
}
