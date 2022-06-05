package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    // this is our service layer of the application.  it handles all the business logic for the app.
    // @Service is how we annotate that this is a service component/class
    public List<Student> getStudents() {
		return List.of(new Student(
			101L,
			"Tom",
			20,
			LocalDate.of(1995, 8, 10),
			"tom@email.com"
		));
	}
}
