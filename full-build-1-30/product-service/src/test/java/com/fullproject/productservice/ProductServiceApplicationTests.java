package com.fullproject.productservice;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fullproject.productservice.dto.ProductRequest;
import com.fullproject.productservice.dto.ProductResponse;
import com.fullproject.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Container
	static MongoDBContainer mongoDBContainer= new MongoDBContainer("mongo:4.4.2");
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ProductRepository productRepository;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.data.mongodb.uri",mongoDBContainer::getReplicaSetUrl);
	}



	@Test
	void shouldCreateProduct() throws Exception {
		ProductRequest productRequest = getProductRequest();
		String productRequestString = objectMapper.writeValueAsString(productRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/product/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content(productRequestString))
				.andExpect(status().isCreated());

		Assertions.assertEquals(1,productRepository.findAll().size());
	}

	private ProductRequest getProductRequest() {
		return ProductRequest.builder()
				.name("iphone13")
				.description("Iphone13 product")
				.price(BigDecimal.valueOf(1300))
				.build();
	}

//	@Test
//	void checkProduct() throws Exception {
//		List<ProductResponse> productResponses= getProductList();
//		String productRequestString = objectMapper.writeValueAsString(productResponses);
//
//		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product/productList")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(productRequestString))
//				.andExpect(status().isFound());
//
//		Assertions.assertEquals();
//	}
//
//	private List<ProductResponse> getProductList() {
//		List<ProductResponse> list= new ArrayList<>();
//		list.add(new ProductResponse("1234","iphone13","iphone 13 max",1300));
//		list.add(new ProductResponse("1235","iphone12","iphone 12 max",1200));
//		list.add(new ProductResponse("1236","iphone11","iphone 11 max",1100));
//		list.add(new ProductResponse("1237","iphone10","iphone 10 max",1000));
//
//		return list;
//	}

}
