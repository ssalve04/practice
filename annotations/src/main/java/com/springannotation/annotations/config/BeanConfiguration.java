package com.springannotation.annotations.config;


import com.springannotation.annotations.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {

    // when you define a class with @Configuration annotation, the spring expect you to define beans in the class.
    // to create bean you can create a method that return the object of a class
    // and you can use @Bean annotation so the ioc container knows what bean to use

    @Bean
    public TestBean testBean(){
        return new TestBean();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
