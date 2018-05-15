package com.zemoso.automation.repositories;

import com.zemoso.automation.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByName(String name);

    @Query("SELECT s FROM Student s WHERE s.gender = 'male'")
    List<Student> findMale();

    @Query("SELECT s FROM Student s group by s.gender")
    List<Student> findStudents();


}