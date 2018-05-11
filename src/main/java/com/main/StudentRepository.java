package com.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.DirtiesContext;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    @Query( "SELECT s FROM StudentEntity s WHERE s.name = 'student A'")
    StudentEntity findByName(String name);

}