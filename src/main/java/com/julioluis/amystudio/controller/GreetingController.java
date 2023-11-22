package com.julioluis.amystudio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/sayHello")
    public String greet() {
        return "Hello world!!";
    }
}
