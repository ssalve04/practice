package com.springannotation.annotations.service;

import com.springannotation.annotations.enitity.Student;
import com.springannotation.annotations.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents() {

        return studentRepository.findAll();

    }
}
