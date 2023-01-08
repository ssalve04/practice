package com.tmobile.tinterview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tmobile.tinterview.service.UserService;


import com.tmobile.tinterview.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/web/service")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value="/users/{id}")
    public ResponseEntity<User> getMethodName(@PathVariable("id") String param) {

       ResponseEntity<User> user= userService.getUser(param);


        return  ResponseEntity.status(HttpStatus.OK).body(user.getBody());
    }
    

    @GetMapping(value="/users")
    public ResponseEntity<List<User>> getUsers() {

       ResponseEntity<List<User>> users= userService.getUsers();

       return ResponseEntity.status(HttpStatus.OK).body(users.getBody());
    }


}
