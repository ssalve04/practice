package com.beatr.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.beatr.productservice.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    
}
