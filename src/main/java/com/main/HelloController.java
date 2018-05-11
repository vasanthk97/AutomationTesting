package com.main;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.*;

@RestController
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

    @RequestMapping(value = "/sayHello", method = RequestMethod.POST, consumes = {"application/json"})
    public String postObject(@RequestBody JsonNode inputJson) {

        return inputJson.get("message").toString();
    }


}
