package com.week2.mvc.mvc.controllers;

import com.week2.mvc.mvc.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @GetMapping("/manthan/{empid}/{empemail}")
    public EmployeeDTO getEmployeeDetails(@PathVariable (name = "empid") Long id,
                                          @RequestParam (required = false) String name,
                                          @PathVariable (name = "empemail") String email,
                                          @RequestParam (required = false) Integer age){
        return new EmployeeDTO(id, name, email, age);
    }

    /*
    --> By default browser fire GET method
    --> to fire POST method, we mimic the frontend first
    */

    @PostMapping("/{empid}")
    public EmployeeDTO updateEmp(@PathVariable (name = "empid") Long id){
        EmployeeDTO emp = new EmployeeDTO();

        if(id == 1){
            emp.setId(id);
            emp.setAge(21);
            emp.setName("Manthan");
            emp.setEmail("manthan@gmail.com");
        }
        return emp;
    }
}
