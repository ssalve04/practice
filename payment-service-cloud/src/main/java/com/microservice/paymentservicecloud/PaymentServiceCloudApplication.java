package com.microservice.paymentservicecloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class PaymentServiceCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceCloudApplication.class, args);
	}

}
