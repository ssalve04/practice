package com.kafka.kafkaexample.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListner {

    @KafkaListener(topics = "demotopic",groupId = "groupId")
    void listner(String data){
        System.out.println("Listener received a data"+data);
    }
}
