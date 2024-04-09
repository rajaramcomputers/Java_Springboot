package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceimpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceimpl(EmployeeRepository theEmployeeRepository){
        employeeRepository=theEmployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee temp=null;
        if(result.isPresent()){
        temp=result.get();
        }
        else{
        throw new RuntimeException("Cannot find employee id");
        }
        return temp;
    }
    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }
@Transactional
    @Override
    public void deleteById(int theId) {
    employeeRepository.deleteById(theId);
    }
}
