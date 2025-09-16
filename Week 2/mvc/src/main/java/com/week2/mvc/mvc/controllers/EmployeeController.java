package com.week2.mvc.mvc.controllers;

import com.week2.mvc.mvc.dto.EmployeeDTO;
import com.week2.mvc.mvc.services.EmployeeServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {


//=============================================================================================================

    private final EmployeeServices employeeServices;


    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }


    //============================================================================================================


    @GetMapping("/{empid}")
    public EmployeeDTO getEmployeeById(@PathVariable (name = "empid") Long id){
        return employeeServices.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployee(@RequestParam (required = false) Long age){
        return employeeServices.getAllEmployee();
    }

//============================================================================================================

    /*
    --> By default browser fire GET method
    --> to fire POST method, we mimic the frontend first
    */

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        return employeeServices.createNewEmployee(inputEmployee);
    }
}
