package com.microservice.orderservicecloud.service;

import com.microservice.orderservicecloud.common.Payment;
import com.microservice.orderservicecloud.common.TransactionRequest;
import com.microservice.orderservicecloud.common.TransactionResponse;
import com.microservice.orderservicecloud.entity.Order;
import com.microservice.orderservicecloud.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest transactionRequest){

        String response="";

        Order order= transactionRequest.getOrder();
        Payment payment=transactionRequest.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest call

        Payment paymentResponse=restTemplate.postForObject("http://PAYMENT_SERVICE/payment/paymentRequest",payment,Payment.class);

       response=paymentResponse.getPaymentStatus()
                                .equals("success")?"payment processing succesful and order placed":"there is a failure in payment";
         repository.save(order);
         return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response );
    }
}
