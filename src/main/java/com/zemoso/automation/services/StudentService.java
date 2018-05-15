package com.zemoso.automation.services;

import com.zemoso.automation.models.Student;
import com.zemoso.automation.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Collection<Student> getAllStudents()
    {
        List<Student> studentList = new ArrayList<Student>();
        for (Student student : studentRepository.findAll()) {
            studentList.add(student);
        }
        return studentList;
    }

    public Collection<Student> getAllMales() {

        List<Student> studentList = new ArrayList<Student>();

        for (Student student : studentRepository.findMale()) {
            studentList.add(student);
        }

        return studentList;
    }

    public Optional<Student> findById(@PathVariable Long id){
        Optional<Student> student=studentRepository.findById(id);

        return student;
    }
}
