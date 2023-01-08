package com.springannotation.annotations.repository;

import com.springannotation.annotations.enitity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Component  // @Component is a class level annotation and is used to denote a class as component
//@Service
//@Repository
//@Controller
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
