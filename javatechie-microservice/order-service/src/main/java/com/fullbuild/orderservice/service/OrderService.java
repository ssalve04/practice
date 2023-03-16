package com.fullbuild.orderservice.service;

import com.fullbuild.orderservice.dto.InventoryResponse;
import com.fullbuild.orderservice.dto.OrderLineItemsDto;
import com.fullbuild.orderservice.dto.OrderRequest;
import com.fullbuild.orderservice.model.Order;
import com.fullbuild.orderservice.model.OrderLineItems;
import com.fullbuild.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private final WebClient webClient;

    public void placeOrder(@RequestBody OrderRequest orderRequest){
        Order order= new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItemsList= orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItemsList);

        List<String> skuCodeList = order.getOrderLineItemsList().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        //call inventory service and place order if the product is in stock
        InventoryResponse[] inventoryResponseArray= webClient.get()
                .uri("http://localhost:8082/api/v1/inventory",uriBuilder -> uriBuilder.queryParam("skuCode",skuCodeList).build())
                        .retrieve()
                                .bodyToMono(InventoryResponse[].class)
                                        .block();

        assert inventoryResponseArray != null;
        boolean allProductsInStock=Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInStock);

        if(allProductsInStock) {
            orderRepository.save(order);
        }else {
            throw new IllegalArgumentException("Product is not in stock");
        }
    }
    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems= new OrderLineItems();
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());

        return orderLineItems;
    }

}
