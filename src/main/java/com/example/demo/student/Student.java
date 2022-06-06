package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

<<<<<<< HEAD
import javax.persistence.Column;
=======
>>>>>>> fac1c1b0d21ed3738ec477f78b24bf9ca4245537
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

// map class to table in postgresql
<<<<<<< HEAD
@Entity(name = "Student") // default name is class name, but you can specify table name as well
@Table
public class Student {

    /*
     * Annotation for the id property.
     * 
     * @Id tells us that id is a primary key in the Student table in SQL
     * 
     * @SequenceGenerator lets us autogenerate Ids from in a sequence. So if our
     * first Id gets created as 1, then the next object will have an id of
     * allocationSize from 1, etc. This is the BIG SERIAL data type in SQL.
     * 
     * @GeneratedValue gets us a generated value for Id to be placed in the id
     * property
     * 
     * @Column gives us some control over the properties of our SQL column
     */
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @Column(name = "id", updatable = false)
=======
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
>>>>>>> fac1c1b0d21ed3738ec477f78b24bf9ca4245537
    private long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
<<<<<<< HEAD

    @Column(name = "DOB")
=======
>>>>>>> fac1c1b0d21ed3738ec477f78b24bf9ca4245537
    private LocalDate dob;

    @Column(name = "email_address", unique = true)
    private String email;

<<<<<<< HEAD
    // @Transient annotation tells us that it doesn't need to be a column in the
    // database since we can just calculate it each time.
    @Transient
    @Column(name = "age")
=======
    // this annotation tells us that it doesn't need to be a column in the database
    // since we can just calculate it each time.
    @Transient
>>>>>>> fac1c1b0d21ed3738ec477f78b24bf9ca4245537
    private int age;

    // Constructors

    public Student() {
    };

    public Student(long id, String name, LocalDate dob, String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Student(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    // GETTER & SETTER Methods

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    // public void setAge(int age) {
    // this.age = age;
    // }

    public LocalDate getDOB() {
        return this.dob;
    }

    public void setDOB(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
