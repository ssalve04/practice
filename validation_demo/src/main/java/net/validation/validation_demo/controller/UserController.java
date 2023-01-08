package net.validation.validation_demo.controller;


import jakarta.validation.Valid;
import net.validation.validation_demo.dto.UserRequest;
import net.validation.validation_demo.entity.User;
import net.validation.validation_demo.exception.UserNorFoundException;
import net.validation.validation_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){

        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int userId)throws UserNorFoundException {

        return ResponseEntity.ok(userService.getUser(userId));
    }
}
