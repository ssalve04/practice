package com.springannotation.annotations.controller;


import com.springannotation.annotations.TestBean;
import com.springannotation.annotations.enitity.Student;
import com.springannotation.annotations.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/web/studentportal")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TestBean testBean;


    @GetMapping("/all")
    public ResponseEntity<List<Student>> getStudents(){

        testBean.method();
        return ResponseEntity.ok( studentService.getStudents());
    }
}
