package com.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping("/")
    @ResponseBody
    public String greeting() {
        return "Hello World";
    }

    @RequestMapping(value = "/getHello/")
    @ResponseBody
    public MessageEntity getObject() {
        return new MessageEntity("main world");
    }



}
