package com.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    StudentEntity findByName(String name);

    @Query("SELECT s FROM StudentEntity s WHERE s.gender = 'male'")
    List<StudentEntity> findMale();

}