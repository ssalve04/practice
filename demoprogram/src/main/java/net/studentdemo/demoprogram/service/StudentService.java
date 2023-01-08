package net.studentdemo.demoprogram.service;


import lombok.AllArgsConstructor;
import net.studentdemo.demoprogram.entity.Student;
import net.studentdemo.demoprogram.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService  {
    @Autowired
    StudentRepository studentRepository;
//    RestTemplate restTemplate;
    public List<Student> getStudent(Integer age) {

        if(age==null){
            return studentRepository.findAll();
        }

        return studentRepository
                                    .findAll()
                                    .stream()
                                    .filter(s->s.getAge()>age)
                                    .collect(Collectors.toList());
    }

    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }
}
