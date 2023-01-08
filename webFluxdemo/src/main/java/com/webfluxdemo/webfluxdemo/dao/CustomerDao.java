package com.webfluxdemo.webfluxdemo.dao;


import com.webfluxdemo.webfluxdemo.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    public List<Customer> getAllCustomer(){

        // in terms of event programming the spring boor will use Netty server instead of TomCat
        // this is a traditional approach where you are waiting for the execution in a synchronous manner
        // this is synchronous blocking
       return IntStream.rangeClosed(1,50)
               .peek(CustomerDao::sleepExecution)
                .peek(i-> System.out.println("Processing count : "+i))
                .mapToObj(i->new Customer(i,"customer"+i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getAllCustomerStream(){
        return Flux.range(1,50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i-> System.out.println("Processing count : "+i))
                .map(i->new Customer(i,"Customer"+i));
    }

    public Flux<Customer> getAllCustomerStreamNoDelay(){
        return Flux.range(1,50)
                .doOnNext(i-> System.out.println("Processing count : "+i))
                .map(i->new Customer(i,"Customer"+i));
    }
    private static void sleepExecution(int i)  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
