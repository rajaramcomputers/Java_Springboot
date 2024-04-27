package com.luv2code.springboot.thymeleafcruddemo.controller;

import com.luv2code.springboot.thymeleafcruddemo.entity.Employee;
import com.luv2code.springboot.thymeleafcruddemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }
    @GetMapping("/list")
    public String listEmployees(Model theModel){
        List<Employee> theEmployees=employeeService.findAll();
        theModel.addAttribute("employees",theEmployees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
    Employee employee=new Employee();
    theModel.addAttribute("employee",employee);
    return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id,Model model){
    Employee employee=employeeService.findById(id);
    model.addAttribute("employee",employee);
    return "employees/employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee)
    {
     employeeService.save(theEmployee);
     return "redirect:/employees/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){
    employeeService.deleteById(id);
    return "redirect:/employees/list";
    }
}
