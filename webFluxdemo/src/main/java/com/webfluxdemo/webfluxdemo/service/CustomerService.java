package com.webfluxdemo.webfluxdemo.service;


import com.webfluxdemo.webfluxdemo.dao.CustomerDao;
import com.webfluxdemo.webfluxdemo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getAllCustomers(){

        Long start=System.currentTimeMillis();
        List<Customer> customers=customerDao.getAllCustomer();
        Long end =System.currentTimeMillis();
        System.out.println("Time difference: " + (end-start));

        return customers;
    }

    public Flux<Customer> getAllCustomerStream(){

        Long start=System.currentTimeMillis();
        Flux<Customer> customers=customerDao.getAllCustomerStream();
        Long end =System.currentTimeMillis();
        System.out.println("Time difference: " + (end-start));

        return customers;
    }
}
