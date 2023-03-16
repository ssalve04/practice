package com.beatr.restapi.controller;

import com.beatr.restapi.model.Department;
import com.beatr.restapi.model.User;
import com.beatr.restapi.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    private final String URI_DEPARTMENT_API = "http://localhost:8081/department/api/";
    private final String URI_DEPARTMENT_ID = "http://localhost:8081/department/api/{id}";

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return user;
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public Users retrieveUser() {
        List<User> list = new ArrayList<>();
        Users users = new Users();
        User user1 = new User(1, "Beatriz", "beatrizristau@gmail.com", "25801");
        list.add(user1);
        User user2 = new User(1, "Carlos", "carlosu@gmail.com", "25900");
        list.add(user2);
        users.setUsersList(list);
        return users;
    }

    @GetMapping("/department")
    public String getUsersInDepartment() {

//        RestTemplate restTemplate = new RestTemplate();
//Parse the string after getting the response
        String DepartmentStr = restTemplate.getForObject(URI_DEPARTMENT_API, String.class);

        return DepartmentStr;
    }

    @GetMapping("/departmentById")
    public String getDepartmentById() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "1");

//        RestTemplate restTemplate = new RestTemplate();

        String DepartmentStr = restTemplate.getForObject(URI_DEPARTMENT_ID, String.class, params);

        return DepartmentStr;
    }
}
