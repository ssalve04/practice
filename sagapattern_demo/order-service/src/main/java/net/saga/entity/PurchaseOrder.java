package net.saga.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.saga.event.OrderStatus;
import net.saga.event.PaymentStatus;


@Entity
@Table(name="purchase_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrder {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer price;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

}
