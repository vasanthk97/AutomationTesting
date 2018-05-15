package com.zemoso.automation.services;

import com.zemoso.automation.DAOs.StudentDAO;
import com.zemoso.automation.models.Student;
import com.zemoso.automation.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    StudentDAO dao;
    public List<Student> getAllStudents()
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

    public Optional<Student> findById(@PathVariable long id){
        Optional<Student> student=studentRepository.findById(id);

        return student;
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void get500()
    {   studentRepository.findStudents();


    }

    public List<Student> findAll(){
        return dao.findAll();
    }

    public List<Student> findFemale(){
        return dao.findFemale();
    }



}
