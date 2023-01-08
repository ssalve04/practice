package net.javaguides.departmentservice.controller;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.service.DepartmentService;
import net.javaguides.departmentservice.service.DepartmentServiceImp;
import net.javaguides.departmentservice.util.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    Logger logger= LogManager.getLogger(DepartmentController.class);
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){

        logger.info("DepartmentController::saveDepartment department request", Mapper.mapToJsonStrin(department));
        Department savedDepartment = departmentService.saveDepartment(department);
        logger.info("DepartmentController::saveDepartment response from service", Mapper.mapToJsonStrin(savedDepartment));
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long departmentId){
        logger.info("DepartmentController::getDepartmentById fetch department by id{}", departmentId);
        Department department= departmentService.getDepartmentById(departmentId);
        logger.info("DepartmentController::getDepartmentById response from service", Mapper.mapToJsonStrin(department));
        return ResponseEntity.ok(department);

    }

}
