package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    // inject employeeDao
    @Autowired
public EmployeeRestController(EmployeeService theEmployeeService){
    employeeService=theEmployeeService;
}

// create a end point /employees
@GetMapping("/employees")
    public List<Employee> findAll(){
    return employeeService.findAll();
}

@GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
    Employee emp=employeeService.findById(employeeId);
    if(emp == null){
    throw new RuntimeException("Employee with ID "+employeeId+" not found");
    }
    return emp;
}

@PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;
}

@PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
    Employee dbEmployee=employeeService.save(theEmployee);
    return dbEmployee;
}

@DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
    Employee temp=employeeService.findById(employeeId);
    if(temp == null){
      throw new RuntimeException("Couldn't found employee with Id "+employeeId);
    }
    employeeService.deleteById(employeeId);
    return "Deleted Employee with Id "+employeeId;
}
}
