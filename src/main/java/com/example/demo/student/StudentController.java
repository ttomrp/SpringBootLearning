package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// api layer
@RestController
@RequestMapping(path = "api/v1/student") // path that must be entered in browser to access api
                                         // localhost:8080/api/v1/student
public class StudentController {
    // this class will hold all resources for our API Layer to interact with Student
    // class
    // @RestController is how we annotate that this is a RESTful API/controller

    private final StudentService studentservice;

    @Autowired
    public StudentController(StudentService studentservice) {
        // @Autowired automatic dependency injection
        // better to avoid something like 'this.studentservice = new StudentService()'
        this.studentservice = studentservice;
    }

    // retrieves an object from the database
    @GetMapping
    public List<Student> getStudents() {
        return studentservice.getStudents();
    }

    /*
     * Take request JSON object and map it to Student object. PostMapping
     * lets us post this new object to our database.
     */
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentservice.addNewStudent(student);
    }

    // to delete the url will be localhost:8080/api/v1/student/<studentId>
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentservice.deleteStudent(studentId);
    }

    // url = localhost:8080/api/v1/student/<studentId>?name=<new name>&email=<new
    // email>
    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentservice.updateStudent(studentId, name, email);
    }
}
