package com.apolis.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apolis.entity.Product;
import com.apolis.entity.ProductList;

@Service
public class ProductService {

    public static final String END_POINT = "https://jsonplaceholder.typicode.com/users/";

    public Product getProduct(String productId) {

        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(END_POINT + productId, Product.class);
        return product;

    }

    public List<Product> getAllProducts() {

        RestTemplate restTemplate = new RestTemplate();
        //  ProductList productList = restTemplate.getForObject(END_POINT, ProductList.class);
        
        Product[] productArray= restTemplate.getForObject(END_POINT, Product[].class);

       

        return  Arrays.asList(productArray);

    }

}
