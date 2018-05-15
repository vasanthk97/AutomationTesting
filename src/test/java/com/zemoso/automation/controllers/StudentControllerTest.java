package com.zemoso.automation.controllers;


import com.zemoso.automation.controller.StudentController;
import com.zemoso.automation.models.Student;
import com.zemoso.automation.services.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTest {
    @MockBean
    private StudentService studentService;
    private MockMvc mockMvc;
    @InjectMocks
    private StudentController studentController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();

    }

    @Test
    public void retrieveAllStudents() throws Exception {
        Student student1 = new Student(1, "some_name_1", "male");
        Student student2 = new Student(2, "some_name_2", "male");

        when(studentService.getAllStudents()).thenReturn(
                Arrays.asList(student1, student2));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/student/getAllStudents")
                .accept(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:1,name:some_name_1,gender:male},{id:2,name:some_name_2,gender:male}]"));

    }

    @Test
    public void addStudentClientError() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
                .post("/student/addStudent/")
                .content("hello")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(request)
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void getServerError() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders
                .get("/student/get500/");

        this.mockMvc.perform(request)
                .andExpect(status().is5xxServerError());

    }


}
