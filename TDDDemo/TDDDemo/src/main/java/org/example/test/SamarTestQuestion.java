package org.example.test;

public class SamarTestQuestion {
//    print from 1 to 100. If number divisible by 3 print ping, divisble by 5 print pong, divisible by both print ping pong

    public String checkMultiples(int num) {

        if(num < 1 || num > 100) {
            throw new IllegalArgumentException();
        }
        if (num % 3 == 0 && num % 5 == 0) {
            return "ping pong";
        }
        else if(num % 3 == 0) {
            return "ping";
        }
        else if(num % 5 == 0) {
            return "pong";
        }


        return null;
    }


}
