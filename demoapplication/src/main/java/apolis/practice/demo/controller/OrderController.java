package apolis.practice.demo.controller;

// fetch data depending on the order id

import apolis.practice.demo.entity.Order;
import apolis.practice.demo.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/web/apolis/")
@AllArgsConstructor
@NoArgsConstructor
public class OrderController {

    OrderService orderService;

    @GetMapping(value = "order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") Integer orderId){

        Order order= orderService.getOrderfromId(orderId);

        return ResponseEntity.ok(order);
    }

    @GetMapping(value = "order")
    public ResponseEntity<List<Order>> getAllOrders(){

        List<Order> list= orderService.getAllorders();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){

        Order savedOrder= orderService.saveOrder(order);

        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }



}
