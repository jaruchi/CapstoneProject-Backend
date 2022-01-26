package com.cpbackend.cpbackendapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequirementController {

    @GetMapping("/helloworld")
    public String helloWorld(){
        return "Hello World";
    }
}
