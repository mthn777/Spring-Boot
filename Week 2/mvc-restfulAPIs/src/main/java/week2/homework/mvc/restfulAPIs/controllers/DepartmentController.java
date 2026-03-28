package week2.homework.mvc.restfulAPIs.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import week2.homework.mvc.restfulAPIs.annotations.IsAPrimeNumberAnnotation;
import week2.homework.mvc.restfulAPIs.dto.DepartmentDTO;
import week2.homework.mvc.restfulAPIs.exception.ResourseNotFoundException;
import week2.homework.mvc.restfulAPIs.services.DepartmentService;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(path = "/department")
public class DepartmentController {

    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById (@PathVariable (name = "departmentId") Long id){
        return departmentService.getDepartmentById(id)
                .map(departmentDTO -> ResponseEntity.ok(departmentDTO))
                .orElseThrow(() -> new ResourseNotFoundException("Employee Not Found..."));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments (){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody @Valid DepartmentDTO inputDepartment){
        return new ResponseEntity<>(departmentService.createNewDepartment(inputDepartment), HttpStatus.CREATED);
    }

    @PutMapping(path = "{departmentId}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody DepartmentDTO departmentDTO, @PathVariable Long id){
        return ResponseEntity.ok(departmentService.updateDepartment(departmentDTO, id));

    }

    @PatchMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updatePartialDepartment(@RequestBody Map<String, Object> updates,
                                                                 @PathVariable (name = "departmentId") Long id){
        return ResponseEntity.ok(departmentService.updatePartialDepartment(updates, id));
    }

    @DeleteMapping(path = "{departmentId}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable (name = "departmentId") Long id){
            if(departmentService.deleteDepartment(id)) return ResponseEntity.ok(true);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);

    }

    @GetMapping(path = "/prime number/{input}")
    public ResponseEntity<Optional<String>> isPrimeNumber(@PathVariable
                                                     @IsAPrimeNumberAnnotation
                                                     Long input){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Optional.of("is a Prime Number"));
    }
}

