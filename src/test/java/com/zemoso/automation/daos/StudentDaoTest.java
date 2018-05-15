package com.zemoso.automation.daos;

import com.zemoso.automation.DAOs.StudentDAO;
import com.zemoso.automation.models.Student;
import com.zemoso.automation.repositories.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoTest {
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    StudentRepository studentRepository;
    @Test
    public void getFemalesWithInvalidQuery() throws Exception{
        Boolean flagMale=false;
        Student someStudent1= new Student("student A","male");
        studentRepository.save(someStudent1);
        Student someStudent2= new Student("student B","male");
        studentRepository.save(someStudent2);
        Student someStudent3= new Student("student C","female");
        studentRepository.save(someStudent3);
        List<Student> students=null;
        try {
            students=studentDAO.findFemale();

        }
        catch (Exception ex){
            fail(ex.getMessage());
        }
        for (Student student : students)
        {
            if(student.getGender().equals("female")){
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
