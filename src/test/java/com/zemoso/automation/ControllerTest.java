package com.zemoso.automation;


import com.zemoso.automation.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {
    @Autowired
    private HelloController controller;

    @Test
    public void contextLoads() throws Exception {
//        controller = new HelloController();
        assertThat(controller).isNotNull();
    }
}
