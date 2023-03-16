package com.fullproject.productservice.controller;

import com.fullproject.productservice.dto.ProductRequest;
import com.fullproject.productservice.dto.ProductResponse;
import com.fullproject.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping("/productList")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){

      return productService.getAllProducts();
    }
}
