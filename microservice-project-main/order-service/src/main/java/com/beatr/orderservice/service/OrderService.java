package com.beatr.orderservice.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.beatr.orderservice.dto.OrderLineItemsDto;
import com.beatr.orderservice.dto.OrderRequest;
import com.beatr.orderservice.entity.Order;
import com.beatr.orderservice.entity.OrderLineItems;
import com.beatr.orderservice.repository.OrderRepository;

@Service
@Transactional // will automatically create and commit the transactions
public class OrderService {

    @Autowired
    private OrderRepository repository;
    
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
        
        order.setOrderLineItemsList(orderLineItems);

        repository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());

        return orderLineItems;
    }
}
