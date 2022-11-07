package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("/path_param/{param}")
    public String index(@PathVariable String param) {

        System.out.println(param);

        return "index";
    }
}
