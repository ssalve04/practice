package controller;


import model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.StudentServices;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @GetMapping("/students/{studentId}/courses")
    public List<Course> retreiveCoursesForStudent(@PathVariable String studentId){
        return  studentServices.retriveCourses(studentId);

    }
}
