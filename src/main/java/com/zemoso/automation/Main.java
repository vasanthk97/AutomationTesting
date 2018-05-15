package com.zemoso.automation;

import com.zemoso.automation.models.Student;
import com.zemoso.automation.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    StudentRepository repository;

    public static void main(String[] args) {


        SpringApplication.run(Main.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        repository.save(new Student("John", "female"));
        repository.save(new Student("John", "female"));
        repository.save(new Student("John", "male"));


    }


}


