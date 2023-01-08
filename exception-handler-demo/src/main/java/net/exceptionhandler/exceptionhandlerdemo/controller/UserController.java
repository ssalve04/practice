package net.exceptionhandler.exceptionhandlerdemo.controller;


import net.exceptionhandler.exceptionhandlerdemo.advice.UserNotFoundException;
import net.exceptionhandler.exceptionhandlerdemo.entity.User;
import net.exceptionhandler.exceptionhandlerdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/net/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("signup")
    public ResponseEntity<User> saveUser(@RequestBody User user){

        User userSaved= userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    @GetMapping({"{id}",""})
    public ResponseEntity<User> getUser(@PathVariable(required = false) Integer id)throws UserNotFoundException {


        User user= userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> list= userService.getAllUsers();
        return ResponseEntity.ok(list);
    }
}
