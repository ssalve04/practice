package com.springannotation.annotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// it combines three annotations @ComponentScan @EnableAutoconfiguration and @Configuration
// @EnableAutoConfiguration automatically configures the dependency in the jar file
// @ComponentScan scans for all the beans so that they are visible to the ioc container
// @Configuration indicates that given class has @Bean definition methods. So that spring boot can create beans to be used by the application.

public class AnnotationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnotationsApplication.class, args);
	}

}
