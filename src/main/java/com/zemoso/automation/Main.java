package com.zemoso.automation;

import com.zemoso.automation.models.Student;
import com.zemoso.automation.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Main implements CommandLineRunner{

    @Autowired
    StudentRepository repository;
    public static void main(String[] args) {


        SpringApplication.run(Main.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        logger.info("Student id 10001 -> {}", repository.findById(10001L));
            repository.deleteAll();
           repository.save(new Student("John", "female"));
            repository.save(new Student("John", "female"));
        repository.save(new Student("John", "male"));

//        logger.info("Update 10003 -> {}", repository.update(new Student(10001L, "Name-Updated", "New-Passport")));

//        repository.deleteById(10002L);

    }


}


