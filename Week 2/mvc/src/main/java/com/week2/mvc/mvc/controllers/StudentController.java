package com.week2.mvc.mvc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping(path = "/getSecretMessage")
    public String examPaperLeaked(){
        return "Here you become a fooled right here";
    }

}
