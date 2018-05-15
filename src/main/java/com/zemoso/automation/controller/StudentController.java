package com.zemoso.automation.controller;

import com.zemoso.automation.repositories.StudentRepository;
import com.zemoso.automation.models.Student;
import com.zemoso.automation.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    @GetMapping("/getAllStudents")
    public Collection<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping("/getMale")
    public Collection<Student> getAllMales() {
        return studentService.getAllMales();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Optional<Student> findById(@PathVariable Long id) {
        return studentService.findById(id);
    }


}
