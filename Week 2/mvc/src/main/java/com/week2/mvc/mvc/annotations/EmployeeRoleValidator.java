package com.week2.mvc.mvc.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleAnnotation, String> {
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext context) {
        //You made a list of roles that you count as valid.
        if(inputRole == null){return false;}
        List<String> roles = List.of("USER", "ROLE");
        return roles.contains(inputRole);    // checking whether inputRole is valid or not.
    }
}
