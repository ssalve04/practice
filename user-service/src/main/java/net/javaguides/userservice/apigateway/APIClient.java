package net.javaguides.userservice.apigateway;


import net.javaguides.userservice.entity.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "DEPARTMENT_SERVICE", url="http://localhost:8080")
public interface APIClient {

    @GetMapping(value="/api/departments/{id}")
    DepartmentDto getDepartmentById(@PathVariable("id") Long departmentId);
}
