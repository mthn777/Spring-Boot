package week2.homework.mvc.restfulAPIs.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordAnnotation, String> {

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {

        return input.matches(".*[A-Z].*") &&             // At least one uppercase
                input.matches(".*[a-z].*") &&             // At least one lowercase
                input.matches(".*[^a-zA-Z0-9].*") &&      // At least one special char
                input.length() >= 10;
    }
}
