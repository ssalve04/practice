package com.springbatch.springbatchdemo.repository;

import com.springbatch.springbatchdemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
