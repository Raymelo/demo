package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ziqin.lei
 * @since 2018/4/19
 */
@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("wrong")
    public String wrong() throws Exception {
        throw new Exception("something wrong");
    }
}
