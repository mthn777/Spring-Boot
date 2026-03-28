package week2.homework.mvc.restfulAPIs.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsAPrimeNumberValidator.class)
public @interface IsAPrimeNumberAnnotation {

    String message() default "Is not a Prime Number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
