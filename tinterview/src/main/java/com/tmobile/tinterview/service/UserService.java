package com.tmobile.tinterview.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tmobile.tinterview.model.User;

@Service
public class UserService {

    public static final String END_POINT="https://jsonplaceholder.typicode.com/users/";

    public ResponseEntity<User> getUser(String param) {

        RestTemplate restTemplate= new RestTemplate();

       User user= restTemplate.getForObject(END_POINT+param, User.class);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


    public ResponseEntity<List<User>> getUsers() {

        RestTemplate restTemplate= new RestTemplate();

       List<User> users= restTemplate.getForObject(END_POINT, List.class);

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }





}
