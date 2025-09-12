package com.week2.mvc.mvc.controllers;

import com.week2.mvc.mvc.entities.EmployeeEnitity;
import com.week2.mvc.mvc.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {


//=============================================================================================================

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


//============================================================================================================


    @GetMapping("/{empid}")
    public EmployeeEnitity getEmployeeById(@PathVariable (name = "empid") Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<EmployeeEnitity> getAllEmployee(@RequestParam (required = false) Long age){
        return employeeRepository.findAll();
    }

//============================================================================================================

    /*
    --> By default browser fire GET method
    --> to fire POST method, we mimic the frontend first
    */

    @PostMapping
    public EmployeeEnitity updateEmp(@RequestBody EmployeeEnitity newEntity){
        return employeeRepository.save(newEntity);
    }
}
