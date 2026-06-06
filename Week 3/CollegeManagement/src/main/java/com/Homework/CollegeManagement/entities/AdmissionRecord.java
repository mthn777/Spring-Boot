package com.Homework.CollegeManagement.entities;

import com.Homework.CollegeManagement.entities.type.AdmissionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "admission_record")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdmissionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate admissionDate;

    private Integer fees;

    @Enumerated(value = EnumType.STRING)
    private AdmissionStatus admissionStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

}
