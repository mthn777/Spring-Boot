package com.week2.mvc.mvc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.week2.mvc.mvc.annotations.EmployeeRoleAnnotation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {

    private Long id;
    @NotBlank(message = "Name of the employee cannot be blank")
    @Range(min = 3, max = 10)
    private String name;

    @NotBlank(message = "Email of the employee cannot be blank")
    @Email(message = "Enter valid email")
    private String email;

    @NotNull(message = "Age of the employee cannot be blank")
    @Min(value = 10, message = "Age cannot be greater than 18.")
    @Max(value = 80, message = "Age cannot be lesser than 80")
    private Integer age;

    @EmployeeRoleAnnotation
    private String role;

    @NotNull(message = "Salary of Employee should be not null")
    @Positive(message = "Salary of Employee should be positive")
    @Digits(integer = 6, fraction = 2, message = "The salary can be in the form XXXXX.YY")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;

    @PastOrPresent(message = "DateOfJoining field in Employee cannot be in the future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;

}
