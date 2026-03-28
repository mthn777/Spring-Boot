package week2.homework.mvc.restfulAPIs.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordAnnotation {
    String message() default "Password must contain One Uppercase letter, One Lowercase Letter, One special Character, minimum length should be 10";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
