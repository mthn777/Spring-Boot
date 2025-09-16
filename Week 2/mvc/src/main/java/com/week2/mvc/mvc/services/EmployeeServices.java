package com.week2.mvc.mvc.services;

import com.week2.mvc.mvc.dto.EmployeeDTO;
import com.week2.mvc.mvc.entities.EmployeeEnitity;
import com.week2.mvc.mvc.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServices {


    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


//=====================================================================================================================


    public EmployeeServices(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


//=====================================================================================================================


    public EmployeeDTO getEmployeeById(Long id) {

        EmployeeEnitity employeeEnitity = employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employeeEnitity,EmployeeDTO.class);

    }


//=====================================================================================================================


    public List<EmployeeDTO> getAllEmployee() {

        List<EmployeeEnitity> employeeEnitities = employeeRepository.findAll();
        return employeeEnitities
                .stream()
                .map(employeeEnitity -> modelMapper.map(employeeEnitity, EmployeeDTO.class))
                .collect(Collectors.toList());

    }


//=====================================================================================================================


    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
//        EmployeeEnitity employeeEnitity = new EmployeeEnitity();
        EmployeeEnitity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEnitity.class);
        EmployeeEnitity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);

    }
}
