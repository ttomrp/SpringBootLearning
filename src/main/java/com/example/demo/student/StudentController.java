package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// api layer
@RestController
@RequestMapping(path = "api/v1/student") //path that must be entered in browser to access api localhost:8080/api/v1/student
public class StudentController {
    // this class will hold all resources for our API Layer to interact with Student class
    // @RestController is how we annotate that this is a RESTful API/controller

    private final StudentService studentservice;

    @Autowired
    public StudentController(StudentService studentservice) {
        // @Autowired automatic dependency injection
        // better to avoid something like 'this.studentservice = new StudentService()'
        this.studentservice = studentservice;
    }

    @GetMapping
	public List<Student> getStudents() {
		return studentservice.getStudents();
	}
}
