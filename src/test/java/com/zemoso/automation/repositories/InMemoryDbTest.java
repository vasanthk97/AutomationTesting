package com.zemoso.automation.repositories;

import com.zemoso.automation.models.Student;
import com.zemoso.automation.services.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@RunWith(SpringRunner.class)
@DataJpaTest
public class InMemoryDbTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService service;

    @Test
    public void whenNameIsValid() {
        Student someStudent= new Student("testStudent1","male");
        entityManager.persist(someStudent);
        entityManager.flush();
        Student requiredStudent = studentRepository.findByName(someStudent.getName());

        assertThat(requiredStudent.getName())
                .isEqualTo(someStudent.getName());
    }

    @Test
    public void whenNameIsInvalid() {
        Student someStudent= new Student("foo","bar");

        Student requiredStudent = studentRepository.findByName(someStudent.getName());

        assertThat(requiredStudent)
                .isNull();
    }
    @Test
    public void invalidQueryTest() {
        studentRepository.findStudents();
        //intending test to fail raising an exception

    }
    @Test
    public void getMaleTest(){
        Boolean flagFemale=false;
        Student someStudent1= new Student("student A","male");
        studentRepository.save(someStudent1);
        Student someStudent2= new Student("student B","male");
        studentRepository.save(someStudent2);
        Student someStudent3= new Student("student C","female");
        studentRepository.save(someStudent3);

        List<Student> students=new ArrayList<Student>();
            students = studentRepository.findMale();

        for (Student student : students)
        {
            if(student.getGender().equals("male")){
                continue;
            }
            else {
                flagFemale=true;
            }
        }
        if (flagFemale==true)
        {
            fail("test failed, wrong data retrieved");
        }
    }

    @Test
    public void getFemales() throws Exception{
        Boolean flagMale=false;
        Student someStudent1= new Student("student A","male");
        studentRepository.save(someStudent1);
        Student someStudent2= new Student("student B","male");
        studentRepository.save(someStudent2);
        Student someStudent3= new Student("student C","female");
        studentRepository.save(someStudent3);
        List<Student> students=null;
        try {
            students=service.findFemale();

        }
        catch (Exception ex){
            fail(ex.getMessage());
        }
        for (Student student : students)
        {
            if(student.getGender().equals("male")){
                continue;
            }
            else {
                flagMale=true;
            }
        }
        if (flagMale==true)
        {
            fail("test failed, wrong data retrieved");
        }


    }




}
