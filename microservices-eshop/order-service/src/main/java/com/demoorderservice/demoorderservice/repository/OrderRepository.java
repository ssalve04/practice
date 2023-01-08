package com.demoorderservice.demoorderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoorderservice.demoorderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
