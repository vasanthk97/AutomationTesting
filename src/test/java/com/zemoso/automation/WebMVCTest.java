package com.zemoso.automation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zemoso.automation.controller.HelloController;
import com.zemoso.automation.controller.StudentController;
import com.zemoso.automation.models.Dummy;
import com.zemoso.automation.models.MessageEntity;
import com.zemoso.automation.repositories.StudentRepository;
import com.zemoso.automation.services.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WebMVCTest {


    private MockMvc helloMockMvc;

    @Autowired
    StudentRepository studentRepository;

    @Before public void setup() {
        this.helloMockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();

    }


    @Test
    public void shouldReturnMessage() throws Exception {
        this.helloMockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }

    @Test
    public void shouldReturnAppropriateObject() throws Exception {

        this.helloMockMvc
                .perform(get("/getHello/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message")
                        .value("Hello world"));

    }



    @Test
    public void shouldPost() throws Exception {

        MessageEntity messageEntity = new MessageEntity("hello world");

        ObjectMapper map = new ObjectMapper();
        byte[] byteJson = map.writeValueAsString(messageEntity).getBytes();

        this.helloMockMvc
                .perform(post("/sendMessage/")
                        .content(byteJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("hello world")));

    }
    @Test
    public void postInvalidObject() throws Exception {

        Dummy dummy= new Dummy(3);

        ObjectMapper map = new ObjectMapper();
        byte[] byteJson = map.writeValueAsString(dummy).getBytes();

        this.helloMockMvc
                .perform(post("/sendMessage/")
                        .content(byteJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
    @Test
    public void shouldPut() throws Exception {

        MessageEntity messageEntity = new MessageEntity("hello world");
        ObjectMapper map = new ObjectMapper();
        byte[] byteJson = map.writeValueAsString(messageEntity).getBytes();

        this.helloMockMvc
                .perform(put("/editMessage/")
                        .content(byteJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("hello world")));

    }



}