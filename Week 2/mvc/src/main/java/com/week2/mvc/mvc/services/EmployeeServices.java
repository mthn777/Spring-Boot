package com.week2.mvc.mvc.services;

import com.week2.mvc.mvc.dto.EmployeeDTO;
import com.week2.mvc.mvc.entities.EmployeeEntity;
import com.week2.mvc.mvc.exception.ResourceNotFoundException;
import com.week2.mvc.mvc.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import javax.swing.text.html.Option;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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


    public Optional<EmployeeDTO> getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class));
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
        return modelMapper.map(employeeRepository.save(toSaveEntity), EmployeeDTO.class);

    }

//=====================================================================================================================

    public boolean isEmployeeIdExists(Long empid){
        if(!employeeRepository.existsById(empid)) throw new ResourceNotFoundException("Employee Not Found with the id : "+empid);
        return true;
    }

//=====================================================================================================================

    public EmployeeDTO updateEmployeeById(Long empid, EmployeeDTO employeeDTO) {

        isEmployeeIdExists(empid);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(empid);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

//=====================================================================================================================

    public boolean deleteEmployeeById(Long empid) {
        isEmployeeIdExists(empid);
        employeeRepository.deleteById(empid);return true;
    }

//=====================================================================================================================

    public EmployeeDTO updatePartialEmployeeById(Long empid, Map<String, Object> updates) {
        EmployeeEntity employeeEntity = employeeRepository.findById(empid).get();
        updates.forEach((fields, value) -> {
            Field fieldToUpdate = ReflectionUtils.findField(EmployeeEntity.class, fields);
            fieldToUpdate.setAccessible(true);
            ReflectionUtils.setField(fieldToUpdate, employeeEntity, value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
