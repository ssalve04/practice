package com.apolis.controller;

import org.springframework.web.bind.annotation.RestController;

import com.apolis.entity.Product;
import com.apolis.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// URI : https://dummyjson.com/products/1

@RestController
@RequestMapping("web/productservice") // ("web/productservice")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") String productID) {

        Product product = productService.getProduct(productID);
        
        
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> productList = productService.getAllProducts();

        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

}
