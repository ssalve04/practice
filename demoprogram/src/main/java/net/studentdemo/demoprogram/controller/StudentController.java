package net.studentdemo.demoprogram.controller;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.studentdemo.demoprogram.entity.Student;
import net.studentdemo.demoprogram.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("web/")
@AllArgsConstructor
@NoArgsConstructor
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = {"student/{age}","student"})
    public ResponseEntity<List<Student>> getStudent(@PathVariable(required = false) Integer age){

        List<Student> students= studentService.getStudent(age);

        return  ResponseEntity.ok(students);
    }

//    @GetMapping(value = "student")
//    public ResponseEntity<List<Student>> getAllStudents(){
//
//        List<Student> studentList=studentService.getAllStudents();
//
//        return ResponseEntity.ok(studentList);
//    }

}
