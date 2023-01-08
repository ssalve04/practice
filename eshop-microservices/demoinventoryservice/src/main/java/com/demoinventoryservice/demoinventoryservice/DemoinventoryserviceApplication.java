package com.demoinventoryservice.demoinventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demoinventoryservice.demoinventoryservice.entity.Inventory;
import com.demoinventoryservice.demoinventoryservice.repository.InventoryRepository;

@SpringBootApplication
public class DemoinventoryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoinventoryserviceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {

		return args -> {

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("something new");
			inventory1.setQuantity(100);

			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("something newer");
			inventory2.setQuantity(10);

			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);

		};

	}
}
