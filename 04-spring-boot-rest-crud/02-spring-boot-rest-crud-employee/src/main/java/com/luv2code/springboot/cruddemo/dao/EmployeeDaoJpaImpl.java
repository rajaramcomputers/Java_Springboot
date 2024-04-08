package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoJpaImpl implements EmployeeDAO{
//    define fields for entityManager
    private EntityManager entityManager;
//    set up constructor injection
@Autowired
    public EmployeeDaoJpaImpl(EntityManager theEntityManager)
    {
        entityManager=theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
//    create a query
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);
//    execute query and get result list
        List<Employee> employees=theQuery.getResultList();
//    return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee employee=entityManager.find(Employee.class,theId);
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
    Employee dBEmployee=entityManager.merge(theEmployee);
    return dBEmployee;
    }

    @Override
    public void deleteById(int theId) {
    Employee employee=entityManager.find(Employee.class,theId);
    entityManager.remove(employee);
    }
}
