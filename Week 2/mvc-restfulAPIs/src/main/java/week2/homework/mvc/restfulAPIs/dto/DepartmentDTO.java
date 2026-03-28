package week2.homework.mvc.restfulAPIs.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;
import week2.homework.mvc.restfulAPIs.annotations.PasswordAnnotation;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {


    private Long Id;

    @NotNull(message = "Department code should not be null...")
    private String departmentCode;

    @NotEmpty(message = "Department Name can't be Empty")
    @NotBlank(message = "Department Name can't be Blank")
    @Size(min = 3, max =20, message = "Department Name size should be between 3 & 20")
    @Length(min = 3, max =20, message = "Length must be between 3 & 20")
    private String departmentName;

    @Min(value = 1, message = "Minimum employee count is 1")
    @Max(value = 1000, message = "Maximum employee count is 1000")
    private Integer employeeCount;

    @PasswordAnnotation
    private String password;

//    @Positive(message = "budget will always be in positive")
//    private Double budget;
//
//    @PositiveOrZero(message = "Projects can be Zero or Positive")
//    private Integer totalProjects;
//
//    @Negative(message = "Loss will always be in negative")
//    private Double loss;
//
//
//    @DecimalMin(value = "1000.50", message = "Minimum budget limit is 1000.50")
//    @DecimalMax(value = "999999.99", message = "Maximum budget limit exceeded")
//    @Digits(integer = 6, fraction = 2, message = "Invalid decimal format")
//    private BigDecimal annualBudget;
//
//    @Range(min = 1, max = 5, message = "Rating must be between 1 & 5")
//    private Integer rating;
//
//    @AssertFalse(message = "Department can't be Deleted")
//    private Boolean isDeleted;
//
//    @AssertTrue
//    private Boolean isActive;
//
//    @Past(message = "Department create date must be in past")
//    private LocalDate createdAt;
//
//    @PastOrPresent(message = "Last Audit Date must be in past or present")
//    private LocalDate lastAuditDate;
//
//    @Future(message = "Next Audit Date must be in future")
//    private LocalDate nextAuditDate;
//
//    @FutureOrPresent(message = "Project Start Date must be in future or present")
//    private LocalDate projectStartDate;
//
//    @Email(message = "Invalid email format")
//    private String departmentEmail;
//
//    @URL(message = "Invalid website format")
//    private String website;
//
//    @CreditCardNumber(message = "Invalid credit card number")
//    private String departmentCard;

}