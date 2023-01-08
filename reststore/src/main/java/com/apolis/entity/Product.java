package com.apolis.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

// {"id":1,"title":"iPhone 9","description":"An apple mobile which is nothing like apple","price":549,"discountPercentage":12.96,"rating":4.69,"stock":94,
// "brand":"Apple","category":"smartphones","thumbnail":"https://dummyjson.com/image/i/products/1/thumbnail.jpg",
// "images":["https://dummyjson.com/image/i/products/1/1.jpg","https://dummyjson.com/image/i/products/1/2.jpg",
// "https://dummyjson.com/image/i/products/1/3.jpg","https://dummyjson.com/image/i/products/1/4.jpg","https://dummyjson.com/image/i/products/1/thumbnail.jpg"]}


public class Product {

    @JsonProperty("id")
 //   @JsonIgnore(value = null)
   Integer productId;
    String username;
    String email;
    String name;
    
    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", username=" + username + ", email=" + email + ", name=" + name
                + "]";
    }

    
    // Integer price;
    // Float discountPercentage;
    // Float rating;
    // Integer stock;
    // List<String> images;

    // public Product(){};
   
    
    // public String getTitle() {
    //     return title;
    // }
    // public void setTitle(String title) {
    //     this.title = title;
    // }
    // public String getDescription() {
    //     return description;
    // }
    // public void setDescription(String description) {
    //     this.description = description;
    // }
    // public Integer getPrice() {
    //     return price;
    // }
    // public void setPrice(Integer price) {
    //     this.price = price;
    // }
    // public Float getDiscountPercentage() {
    //     return discountPercentage;
    // }
    // public void setDiscountPercentage(Float discountPercentage) {
    //     this.discountPercentage = discountPercentage;
    // }
    // public Float getRating() {
    //     return rating;
    // }
    // public void setRating(Float rating) {
    //     this.rating = rating;
    // }
    // public Integer getStock() {
    //     return stock;
    // }
    // public void setStock(Integer stock) {
    //     this.stock = stock;
    // }
    // public List<String> getImages() {
    //     return images;
    // }
    // public void setImages(List<String> images) {
    //     this.images = images;
    // }


    // public Integer getProductId() {
    //     return productId;
    // }


    // public void setProductId(Integer productId) {
    //     this.productId = productId;
    // }


    // @Override
    // public String toString() {
    //     return "Product [productId=" + productId + ", title=" + title + ", description=" + description + ", price="
    //             + price + ", discountPercentage=" + discountPercentage + ", rating=" + rating + ", stock=" + stock
    //             + ", images=" + images + "]";
    // }
   

    
    

    
}
