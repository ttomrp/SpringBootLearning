package com.example.demo.student;

import java.util.List;
import java.util.Optional;

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

	public void addNewStudent(Student student) {
		Optional<Student> studentByEmail = studentrepository.findStudentByEmail(student.getEmail());
		if (studentByEmail.isPresent()) {
			// if student with this email exists, then throw exception for there already 
			// being an existing student.  Cannot add new student.
			throw new IllegalStateException("email taken");
		}
		
		studentrepository.save(student);
	}
}
