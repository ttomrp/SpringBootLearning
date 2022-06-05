package com.example.demo;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.student.Student;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping
	public static List<Student> hello() {
		return List.of(new Student(
			101L,
			"Tom",
			20,
			LocalDate.of(1995, 8, 10),
			"tom@email.com"
		));
	}

}
