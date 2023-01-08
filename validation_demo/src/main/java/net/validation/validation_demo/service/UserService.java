package net.validation.validation_demo.service;


import net.validation.validation_demo.dto.UserRequest;
import net.validation.validation_demo.entity.User;
import net.validation.validation_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.validation.validation_demo.exception.UserNorFoundException;
import java.util.List;

@Service
    public class UserService {

        @Autowired
        private UserRepository userRepository;

        public User saveUser(UserRequest userRequest){

            User user= User.
                    build(0,userRequest.getName(),userRequest.getEmail(), userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(),userRequest.getNationality());
            return userRepository.save(user);
        }

        public List<User> getAllUsers(){

            return userRepository.findAll();
        }

        public User getUser(int userId) throws UserNorFoundException {

            User user= userRepository.findByUserId(userId);

            if(user!=null){
                return user;
            }
            else {
                throw new UserNorFoundException("User not found "+userId );
            }
        }
    }
