package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student tom = new Student(
                101L,
                "Tom",
                LocalDate.of(1995, 8, 10),
                "tom@email.com"
            );
            Student jim = new Student(
                "Jim",
                LocalDate.of(1997, 8, 10),
                "jim@email.com"
            );

            repository.saveAll(
                List.of(tom, jim)
            );
        };
    }
}
