package net.saga.service;

import net.saga.dto.OrderRequestDto;
import net.saga.event.OrderEvent;
import net.saga.event.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
public class OrderStatusPublish {


    private Sinks.Many<OrderEvent> orderSinks;

    public void publishOrderEvent(OrderRequestDto orderRequestDto, OrderStatus orderStatus){

        OrderEvent orderEvent= new OrderEvent(orderRequestDto,orderStatus);
        orderSinks.tryEmitNext(orderEvent);
    }
}
