package net.exceptionhandler.exceptionhandlerdemo.service;

import net.exceptionhandler.exceptionhandlerdemo.advice.UserNotFoundException;
import net.exceptionhandler.exceptionhandlerdemo.entity.User;
import net.exceptionhandler.exceptionhandlerdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Integer userId) throws UserNotFoundException {
        User user= userRepository.findByid(userId);
        if(user==null){
            throw new UserNotFoundException("User with given id not found!");
        }

        return user;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
