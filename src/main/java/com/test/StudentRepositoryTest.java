package com.test;


import com.config.PersistenceContext;
import com.main.StudentEntity;
import com.main.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceContext.class})

public class StudentRepositoryTest {



    @Autowired
    private StudentRepository studentRepository;

//    @Test
//    public void whenNameIsValid() {
//        StudentEntity someStudent= new StudentEntity("student A");
//
//        StudentEntity requiredStudent = studentRepository.findByName(someStudent.getName());
//
//        assertThat(requiredStudent.getName())
//                .isEqualTo(someStudent.getName());
//    }
//
//    @Test
//    public void whenNameIsInvalid() {
//        StudentEntity someStudent= new StudentEntity("foo");
//
//        StudentEntity requiredStudent = studentRepository.findByName(someStudent.getName());
//
//        assertThat(requiredStudent.getName())
//                .isNotEqualTo(someStudent.getName());
//
//    }
}
