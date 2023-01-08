package com.microservice.paymentservicecloud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment_db")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int paymentId;
    private String paymentStatus;
    private String transactionId;
    private int orderId;
    private double amount;
}
