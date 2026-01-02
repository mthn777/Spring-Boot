package com.week2.mvc.mvc.controllers;

import com.week2.mvc.mvc.dto.EmployeeDTO;
import com.week2.mvc.mvc.exception.ResourceNotFoundException;
import com.week2.mvc.mvc.services.EmployeeServices;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

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
        return employeeServices.getEmployeeById(id)
                .map(employeeDTO -> ResponseEntity.ok(employeeDTO))
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found..."));
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
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee){
        return ResponseEntity.ok(employeeServices.createNewEmployee(inputEmployee));
    }


//============================================================================================================


    @PutMapping(path = "/{empid}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody @Validated EmployeeDTO employeeDTO, @PathVariable Long empid){
        return ResponseEntity.ok(employeeServices.updateEmployeeById(empid, employeeDTO));
    }

//============================================================================================================


    @PatchMapping(path = "/{empid}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@PathVariable Long empid, @RequestBody  Map<String, Object> updates){
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
