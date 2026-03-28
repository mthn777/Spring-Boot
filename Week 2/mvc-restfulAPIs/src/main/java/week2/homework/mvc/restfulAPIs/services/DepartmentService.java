package week2.homework.mvc.restfulAPIs.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import week2.homework.mvc.restfulAPIs.dto.DepartmentDTO;
import week2.homework.mvc.restfulAPIs.entities.DepartmentEntity;
import week2.homework.mvc.restfulAPIs.repositories.DepartmentRepository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    DepartmentRepository departmentRepository;
    ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper){
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }


    public Optional<DepartmentDTO> getDepartmentById(Long id) {
//        Optional<DepartmentEntity> entity = departmentRepository.findById(id);
//        return entity.map(entity1 -> modelMapper.map(entity1, DepartmentDTO.class));

        return departmentRepository.findById(id)
                .map(entity ->
                        modelMapper.map(entity, DepartmentDTO.class));
    }

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departmentEntityList = departmentRepository.findAll();
        return departmentEntityList.stream()
                .map(eachEntity -> modelMapper.map(eachEntity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }


    public DepartmentDTO createNewDepartment(DepartmentDTO inputDepartment) {
        return modelMapper.map(
                departmentRepository.save(
                        modelMapper.map(inputDepartment, DepartmentEntity.class))
                ,DepartmentDTO.class);
    }

    public DepartmentDTO updatePartialDepartment(Map<String, Object> updates, Long id) {
        DepartmentEntity entity = departmentRepository.findById(id).get();
        updates.forEach((field, value) -> {
                Field fieldToUpdate = ReflectionUtils.findField(DepartmentEntity.class, field);
                fieldToUpdate.setAccessible(true);
                ReflectionUtils.setField(fieldToUpdate, entity, value);
        });
        return modelMapper.map(departmentRepository.save(entity), DepartmentDTO.class);

    }

    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO, Long id) {
        DepartmentEntity entity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        entity.setId(id);
        return modelMapper.map(departmentRepository.save(entity), DepartmentDTO.class);
    }

    public Boolean deleteDepartment(Long id) {
        Boolean isDepartmentExists = departmentRepository.existsById(id);
        if(isDepartmentExists){
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}