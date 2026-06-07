package com.week4.devTools.controllers;

import com.week4.devTools.client.impl.EmployeeClientImpl;
import com.week4.devTools.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeClientController {

    @Autowired
    private EmployeeClientImpl employeeClient;

    @GetMapping
    @RequestMapping(path = "/client/employee/get")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
        return new ResponseEntity<>(employeeClient.getAllEmployees(), HttpStatus.FOUND);
    }

    @GetMapping
    @RequestMapping(path = "/client/employee/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId){
        return new ResponseEntity<>(employeeClient.getEmployeeById(employeeId), HttpStatus.FOUND);
    }

    @PostMapping
    @RequestMapping(path = "/client/employee/create")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeClient.createEmployee(employeeDTO), HttpStatus.CREATED);
    }
}
