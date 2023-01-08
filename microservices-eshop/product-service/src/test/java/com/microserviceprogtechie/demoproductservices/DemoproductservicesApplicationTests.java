package com.microserviceprogtechie.demoproductservices;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class DemoproductservicesApplicationTests {

//	@Container
//	static MySQLContainer mySQLContainer = new MySQLContainer("mysql:3.4");

	// @DynamicPropertySource
	// static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
	// 	dynamicPropertyRegistry.add("spring.data.mysql.uri", mySQLContainer::getReplicaSetUrl);

	// }

//	@Test
//	void contextLoads() {
//	}

}
