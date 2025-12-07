package com.week2.mvc.mvc.services;

import com.week2.mvc.mvc.dto.EmployeeDTO;
import com.week2.mvc.mvc.entities.EmployeeEntity;
import com.week2.mvc.mvc.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
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

        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employeeEntity,EmployeeDTO.class);

    }


//=====================================================================================================================


    public List<EmployeeDTO> getAllEmployee() {

        List<EmployeeEntity> employeeEnitities = employeeRepository.findAll();
        return employeeEnitities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());

    }


//=====================================================================================================================


    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
//        EmployeeEntity employeeEnitity = new EmployeeEntity();
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);

    }


    public boolean isEmployeeIdExists(Long empid){
        return employeeRepository.existsById(empid);
    }


    public EmployeeDTO updateEmployeeById(Long empid, EmployeeDTO employeeDTO) {

        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        if(!isEmployeeIdExists(empid)) return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
        employeeEntity.setId(empid);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }


    public boolean deleteEmployeeById(Long empid) {
        if(!isEmployeeIdExists(empid)) return false;
        employeeRepository.deleteById(empid);return true;
    }

    public EmployeeDTO updatePartialEmployeeById(Long empid, Map<String, Object> updates) {
        EmployeeEntity employeeEntity = employeeRepository.findById(empid).get();
        updates.forEach((fields, value) -> {
            Field fieldToUpdate = ReflectionUtils.getRequiredField(EmployeeEntity.class, fields);
            fieldToUpdate.setAccessible(true);
            ReflectionUtils.setField(fieldToUpdate, employeeEntity, value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
