package com.week2.mvc.mvc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController --> tells spring this class handles web requests ( HTTP calls )
@RestController     // this prebuild
public class EmployeeController {

    //MVC BASICS
    // @GetMapping --> maps an HTTP GET request to this method
    @GetMapping(path = "/getSuperSecretMessage")
    public String getMySecretMessage(){
        return "you got my secret message...";    // this msg is sent back as the HTTP response
    }

}
