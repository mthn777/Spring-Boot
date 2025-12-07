package com.week2.mvc.mvc.controllers;

import com.week2.mvc.mvc.dto.EmployeeDTO;
import com.week2.mvc.mvc.services.EmployeeServices;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable (name = "empid") Long id){
        return ResponseEntity.ok(employeeServices.getEmployeeById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
        return ResponseEntity.ok(employeeServices.getAllEmployee());
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


//============================================================================================================


    @PutMapping(path = "/{empid}")
    public EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long empid){
        return employeeServices.updateEmployeeById(empid, employeeDTO);
    }

//============================================================================================================


    @PatchMapping(path = "/{empid}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@PathVariable Long empid, @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(employeeServices.updatePartialEmployeeById(empid, updates));
    }


//============================================================================================================


    @DeleteMapping(path = "/{empid}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long empid){
        boolean deleted = employeeServices.deleteEmployeeById(empid);
        if(!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(true);
    }

}
