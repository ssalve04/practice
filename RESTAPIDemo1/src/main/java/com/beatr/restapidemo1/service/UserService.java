package com.beatr.restapidemo1.service;

import com.beatr.restapidemo1.entity.User;
import com.beatr.restapidemo1.entity.Users;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private static final String ENDPOINT = "https://jsonplaceholder.typicode.com/users/";


    public List<User> getAllUsers() {
        RestTemplate restTemplate = new RestTemplate();
        User[] list = restTemplate.getForObject(ENDPOINT, User[].class);

        List<User> userList = Arrays.asList(list);

        return userList;
    }

    public User getUserById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(ENDPOINT + id, User.class);

        return user;
    }
}
