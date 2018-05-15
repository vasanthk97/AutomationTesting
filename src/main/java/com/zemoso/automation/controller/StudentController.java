package com.zemoso.automation.controller;

import com.zemoso.automation.repositories.StudentRepository;
import com.zemoso.automation.models.Student;
import com.zemoso.automation.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping("/getMale")
    public Collection<Student> getAllMales() {
        return studentService.getAllMales();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Optional<Student> findById(@PathVariable long id) {
        return studentService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/addStudent")
    public void addStudent(@RequestBody  Student student) {
        studentService.addStudent(student);
        return;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/get500")
    public ResponseEntity<?> get500() {
        return new ResponseEntity<Error>(HttpStatus.INTERNAL_SERVER_ERROR); //appropriate error code
    }
    @GetMapping("/getAllStudents2")
    public List<Student> findAll(){
        return studentService.findAll();
    }
    @GetMapping("/getFemales")
    public List<Student> findFemale(){
        return studentService.findFemale();
    }

}
