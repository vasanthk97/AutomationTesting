package com.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.HelloController;
import com.main.MessageEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class WebMVCTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();

    }


    @Test
    public void shouldReturnMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }

    @Test
    public void shouldReturnObject() throws Exception {

        this.mockMvc
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

        this.mockMvc
                .perform(post("/sendMessage/")
                        .content(byteJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("hello world")));

    }

    @Test
    public void shouldPut() throws Exception {

        MessageEntity messageEntity = new MessageEntity("hello world");
        ObjectMapper map = new ObjectMapper();
        byte[] byteJson = map.writeValueAsString(messageEntity).getBytes();

        this.mockMvc
                .perform(put("/editMessage/")
                        .content(byteJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("hello world")));

    }
}