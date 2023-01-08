package com.transactional.transactionalexample.utils;

import com.transactional.transactionalexample.exception.InsufficientAmount;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    private static Map<String,Double> paymentMap= new HashMap<>();

    static {
        paymentMap.put("acc1",120000.0);
        paymentMap.put("acc2",30000.0);
        paymentMap.put("acc3",67000.0);
        paymentMap.put("acc4",100000.0);
        paymentMap.put("acc5",124500.0);
        paymentMap.put("acc6",9000000.0);

    }

    public  static boolean validDateCreditLimit(String accNo, double paidamount){
        if(paidamount>paymentMap.get(accNo)) {
            throw new InsufficientAmount("Insufficient Amount");
        } else{
            return true;
        }
    }
}
