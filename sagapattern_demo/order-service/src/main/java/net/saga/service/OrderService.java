package net.saga.service;


import net.saga.dto.OrderRequestDto;
import net.saga.entity.PurchaseOrder;
import net.saga.event.OrderStatus;
import net.saga.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderStatusPublish orderStatusPublish;

    @Transactional
    public PurchaseOrder createOrder(OrderRequestDto orderRequestDto) {

        PurchaseOrder order= orderRepository.save(convertDtoToEntity(orderRequestDto));
        orderRequestDto.setOrderId(order.getId());
        //produce kafka event with status ORDER_CREATED
        orderStatusPublish.publishOrderEvent(orderRequestDto,OrderStatus.ORDER_CREATED);
        return order;
    }

    public List<PurchaseOrder> getAllOrders(){

        return orderRepository.findAll();
    }
    private PurchaseOrder convertDtoToEntity(OrderRequestDto dto){
        PurchaseOrder purchaseOrder= new PurchaseOrder();
        purchaseOrder.setProductId(dto.getProductId());
        purchaseOrder.setUserId(dto.getUserId());
        purchaseOrder.setOrderStatus(OrderStatus.ORDER_CREATED);
        purchaseOrder.setPrice(dto.getAmount());

        return purchaseOrder;
    }
}
