package com.webfluxdemo.webfluxdemo.handler;

import com.webfluxdemo.webfluxdemo.dao.CustomerDao;
import com.webfluxdemo.webfluxdemo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {
    @Autowired
    private CustomerDao customerDao;

    public Mono<ServerResponse> customerListNoDelay(ServerRequest request){

        Flux<Customer> allCustomerStreamNoDelay = customerDao.getAllCustomerStreamNoDelay();
        return ServerResponse.ok().body(allCustomerStreamNoDelay,Customer.class);

    }


}
