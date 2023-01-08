package net.saga.event;

import lombok.NoArgsConstructor;
import net.saga.dto.OrderRequestDto;

import java.util.Date;
import java.util.UUID;
@NoArgsConstructor
public class OrderEvent implements Event {

    private UUID eventId=UUID.randomUUID();
    private Date date= new Date();
    private OrderRequestDto orderRequestDto;
    private OrderStatus orderStatus;

    @Override
    public UUID getEventId() {
        return eventId;
    }

    @Override
    public Date getEventDate() {
        return date;
    }

    public OrderEvent(OrderRequestDto orderRequestDto, OrderStatus orderStatus) {
        this.orderRequestDto = orderRequestDto;
        this.orderStatus = orderStatus;
    }
}
