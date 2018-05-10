package com.test;


import com.main.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class ControllerTest {

    private HelloController controller;

    @Test
    public void contexLoads() throws Exception {
        controller = new HelloController();
        assertThat(controller).isNotNull();
    }
}
