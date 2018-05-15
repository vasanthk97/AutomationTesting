package com.zemoso.automation.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.zemoso.automation.models.MessageEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        return new MessageEntity("Hello world");
    }

    @RequestMapping(value = "/sendMessage/",method = RequestMethod.POST)
    @ResponseBody
    public String sendObject(@RequestBody JsonNode json) {
        return json.get("message").toString();
    }

    @RequestMapping(value = "/editMessage/",method = RequestMethod.PUT)
    @ResponseBody
    public String editObject(@RequestBody JsonNode json) {
        return json.get("message").toString();
    }
}
