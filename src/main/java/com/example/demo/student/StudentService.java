package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    // this is our service layer of the application.  it handles all the business logic for the app.
    // @Service is how we annotate that this is a service component/class

	private final StudentRepository studentrepository;

	@Autowired
	public StudentService(StudentRepository studentrepository) {
		this.studentrepository = studentrepository;
	}

    public List<Student> getStudents() {
		return studentrepository.findAll();
	}
}
