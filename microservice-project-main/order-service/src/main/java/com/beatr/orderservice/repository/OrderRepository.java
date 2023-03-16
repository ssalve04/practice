package com.beatr.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beatr.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
