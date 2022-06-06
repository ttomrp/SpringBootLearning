package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*
 * This interface gives us our Data Access Layer.
 * Our repository extends and existing repository (JpaRepository) which 
 * already provides a large number of methods to use to query our data in SQL database.
 * We can add our own querying methods to this repository.
 * 
 * Repository<Generic Type, ID>
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // map method to sql query
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
