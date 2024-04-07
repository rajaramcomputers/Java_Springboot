package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudent;
    @PostConstruct
    public void loadData(){
        theStudent=new ArrayList<>();
        theStudent.add(new Student("Poornima","Patel"));
        theStudent.add(new Student("Preeti","Patel"));
        theStudent.add(new Student("Rashmi","Sharma"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
     return theStudent;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        if(studentId >= theStudent.size() || studentId < 0)
        {
        throw new StudentNotFoundException("Student Id not found "+studentId);
        }
        return theStudent.get(studentId);
    }
}
