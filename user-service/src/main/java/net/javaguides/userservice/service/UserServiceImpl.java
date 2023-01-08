package net.javaguides.userservice.service;

import lombok.AllArgsConstructor;
import net.javaguides.userservice.apigateway.APIClient;
import net.javaguides.userservice.entity.DepartmentDto;
import net.javaguides.userservice.entity.ResponseDto;
import net.javaguides.userservice.entity.User;
import net.javaguides.userservice.entity.UserDto;
import net.javaguides.userservice.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
//    private RestTemplate restTemplate;

    private APIClient apiClient;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseDto getUser(Long userId) {

        ResponseDto responseDto= new ResponseDto();
        User user= userRepository.findById(userId).get();
        UserDto userDto= mapToUser(user);

       /*
            using restTemplate without implementation of api gateway version.1.0.0

//        ResponseEntity<DepartmentDto> responseEntity= restTemplate
//                                                        .getForEntity("http://localhost:8080/api/departments/"+user.getDepartmentId(),DepartmentDto.class);

        */

        DepartmentDto departmentDto= apiClient.getDepartmentById(Long.valueOf(user.getDepartmentId()));

//        DepartmentDto departmentDto= responseEntity.getBody();
//
//        System.out.println(responseEntity.getStatusCode());

        responseDto.setUser(userDto);
        responseDto.setDepartment(departmentDto);

        return responseDto;
    }

    private UserDto mapToUser(User user){

        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
