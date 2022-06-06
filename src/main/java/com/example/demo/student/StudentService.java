package com.example.demo.student;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	// this is our service layer of the application. it handles all the business
	// logic for the app.
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
			// being an existing student. Cannot add new student.
			throw new IllegalStateException("email taken");
		}

		studentrepository.save(student);
	}

	public void deleteStudent(Long id) {
		if (!studentrepository.existsById(id)) {
			throw new IllegalStateException("student with Id " + id + " does not exist");
		}

		studentrepository.deleteById(id);
	}

	/*
	 * The Transactional annotation combines multiple writes on a database into a
	 * single operation
	 */
	@Transactional
	public void updateStudent(Long studentId, String name, String email) {

		Student student = studentrepository.findById(studentId).orElseThrow(
				() -> new IllegalStateException("student with Id " + studentId + " does not exist"));

		if (name != null && !name.isBlank() && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}

		if (email != null && !email.isBlank() && !Objects.equals(student.getEmail(), email)) {
			Optional<Student> studentByEmail = studentrepository.findStudentByEmail(email);
			if (studentByEmail.isPresent()) {
				throw new IllegalStateException("student with email already exists");
			}
			student.setEmail(email);
		}
	}
}
