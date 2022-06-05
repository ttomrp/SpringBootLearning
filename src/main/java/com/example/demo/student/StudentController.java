package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/student") //path that must be entered in browser to access api localhost:8080/api/v1/student
public class StudentController {
    // this class will hold all resources for our API Layer to interact with Student class

    @GetMapping
	public static List<Student> getStudents() {
		return List.of(new Student(
			101L,
			"Tom",
			20,
			LocalDate.of(1995, 8, 10),
			"tom@email.com"
		));
	}
}
