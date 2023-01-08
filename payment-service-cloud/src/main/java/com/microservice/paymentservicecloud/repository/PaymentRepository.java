package com.microservice.paymentservicecloud.repository;

import com.microservice.paymentservicecloud.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
