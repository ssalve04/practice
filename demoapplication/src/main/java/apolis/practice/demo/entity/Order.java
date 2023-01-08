package apolis.practice.demo.entity;
//Oder
//        orderid
//        productName
//        price
//        quantity
//        location
//        orderDare

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "order_db")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private String productName;
    private Float price;
    private Integer quantity;
    private String location;
    private Date orderDate;
}
