package com.example.demo.student;

import java.time.LocalDate;

public class Student {
    private long id;
    private String name;
    private int age;
    private LocalDate dob;
    private String email;

    public Student() {};

    public Student(long id, String name, int age, LocalDate dob, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.email = email;
    }
}
