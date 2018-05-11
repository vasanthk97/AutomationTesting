package com.main;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/sendMessage/")
    @ResponseBody
    public String getObject(@RequestBody JsonNode json) {
        return json.get("message").toString();
    }


}
