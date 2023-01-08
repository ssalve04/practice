package apolis.practice.demo.service;


import apolis.practice.demo.entity.Order;
import apolis.practice.demo.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    OrderRepository orderRepository;

    public Order getOrderfromId(Integer orderId) {

        return orderRepository.getReferenceById(orderId);
    }

    public List<Order> getAllorders() {

        return orderRepository.findAll();
    }

    public Order saveOrder(Order order) {

        return  orderRepository.save(order);

    }
}
