package com.arti.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //indication for  java springboot to treat it as API gateway
public class HelloController {
    //-->/hello

    @GetMapping("hello")
    public String hello() {
//        return "Hello World!";
        return "<H1> Hello World </H1>";
    }
}
