package com.fullbuild.inventoryservice;

import com.fullbuild.inventoryservice.model.Inventory;
import com.fullbuild.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory1=new Inventory();
			inventory1.setSkuCode("iphone_5");
			inventory1.setQuantity(150);

			Inventory inventory2=new Inventory();
			inventory2.setSkuCode("iphone_6");
			inventory2.setQuantity(200);

			Inventory inventory3=new Inventory();
			inventory3.setSkuCode("iphone_7");
			inventory3.setQuantity(220);

			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
			inventoryRepository.save(inventory3);

		};
	}

}
