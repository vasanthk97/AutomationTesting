package com.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/getAllStudents")
    public Collection<StudentEntity> getAllStudents() {

        List<StudentEntity> studentList = new ArrayList<StudentEntity>();
        for (StudentEntity student : studentRepository.findAll()) {
            studentList.add(student);
            }

        return studentList;
}

    @RequestMapping("/getMale")
    public Collection<StudentEntity> getAllMales() {

        List<StudentEntity> studentList = new ArrayList<StudentEntity>();
        for (StudentEntity student : studentRepository.findMale()) {
            studentList.add(student);
        }

        return studentList;
    }


}
