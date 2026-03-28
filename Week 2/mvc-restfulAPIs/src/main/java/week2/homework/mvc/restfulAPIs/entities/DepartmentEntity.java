package week2.homework.mvc.restfulAPIs.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String departmentCode;

    private String departmentName;

    private Integer employeeCount;

    private String password;

//    private Double budget;
//
//    private Integer totalProjects;
//
//    private Double loss;
//
//
//    private BigDecimal annualBudget;
//
//    private Integer rating;
//
//    private Boolean isDeleted;
//
//    private Boolean isActive;
//
//    private LocalDate createdAt;
//
//    private LocalDate lastAuditDate;
//
//    private LocalDate nextAuditDate;
//
//    private LocalDate projectStartDate;
//
//    private String departmentEmail;
//
//    private String website;
//
//    private String departmentCard;
}
