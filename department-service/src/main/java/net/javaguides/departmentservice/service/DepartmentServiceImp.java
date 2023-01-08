package net.javaguides.departmentservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.util.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentServiceImp implements DepartmentService{


    Logger logger= LogManager.getLogger(DepartmentServiceImp.class);
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        logger.info("DepartmentServiceImp::saveDepartment excution started");
        logger.info("DepartmentServiceImp::saveDepartment payload{} ", Mapper.mapToJsonStrin(department));
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        logger.info("DepartmentServiceImp::getDepartmentById excution started");
        logger.info("DepartmentServiceImp::getDepartmentById response{}", Mapper.mapToJsonStrin(departmentId));
        return departmentRepository.findById(departmentId).get();
    }
}
