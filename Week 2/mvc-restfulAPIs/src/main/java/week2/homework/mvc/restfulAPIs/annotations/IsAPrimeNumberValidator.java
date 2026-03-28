package week2.homework.mvc.restfulAPIs.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsAPrimeNumberValidator implements ConstraintValidator<IsAPrimeNumberAnnotation, Long> {
    @Override
    public boolean isValid(Long inputNumber, ConstraintValidatorContext constraintValidatorContext) {
        if(inputNumber <= 1) return false;
        for(int i = 2; i*i <= inputNumber; i++){
            if(inputNumber % i == 0){
                return false;
            }
        }
        return true;
    }
}
