package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//To define any custom path
//@RepositoryRestResource(path = "employee")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
