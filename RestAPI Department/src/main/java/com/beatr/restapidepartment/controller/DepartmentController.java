package com.beatr.restapidepartment.controller;

import com.beatr.restapidepartment.model.Department;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department/api")
public class DepartmentController {

    @GetMapping("/")
    public List<Department> getDepartment() {
        List<Department> deptList = new ArrayList<>();
        Department dept1 = new Department(1, "Computer Science", "loc1");
        Department dept2 = new Department(2, "Mathematics", "loc2");
        Department dept3 = new Department(3, "Electrical Engineering", "loc3");
        Department dept4 = new Department(4, "Business", "loc4");

        deptList.add(dept1);
        deptList.add(dept2);
        deptList.add(dept3);
        deptList.add(dept4);

        return deptList;
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable int id) {
        List<Department> deptList = new ArrayList<>();
        Department dept1 = new Department(1, "Computer Science", "loc1");
        Department dept2 = new Department(2, "Mathematics", "loc2");
        Department dept3 = new Department(3, "Electrical Engineering", "loc3");
        Department dept4 = new Department(4, "Business", "loc4");

        deptList.add(dept1);
        deptList.add(dept2);
        deptList.add(dept3);
        deptList.add(dept4);

        for (Department dept: deptList) {
            if(dept.getId() == id) {
                return dept;
            }
        }
        return null;
    }
}
