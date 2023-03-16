package com.techie.api.service;

import com.techie.api.dto.Payment;
import com.techie.api.dto.TransactionRequest;
import com.techie.api.dto.TransactionResponse;
import com.techie.api.entity.Order;
import com.techie.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderRepository orderRepository;

    public TransactionResponse saveOrder(TransactionRequest transactionRequest){
        String response="";
        Order order= transactionRequest.getOrder();
        Payment payment= transactionRequest.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        Payment paymentResponse= restTemplate.postForObject("http://payment-service/api/payment/create",payment,Payment.class);
        assert paymentResponse != null;
        response=paymentResponse.getPaymentStatus().equals("success")?"payment successfully ":"failure in payment";
        orderRepository.save(order);
        return new TransactionResponse(order,paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }
}
