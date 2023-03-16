package com.beatr.restapidemo1.controller;

import com.beatr.restapidemo1.entity.User;
import com.beatr.restapidemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    // updat
    @Autowired
    UserService service;

    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers() {
        List<User> list = service.getAllUsers();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {

        User user = service.getUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
