package com.jyh.jiangboot.com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class HelloController {


    @RequestMapping("/")
    public String hello(){
        return "Hello";
    }

}
