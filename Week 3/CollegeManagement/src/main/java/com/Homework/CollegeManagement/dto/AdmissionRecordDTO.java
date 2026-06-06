package com.Homework.CollegeManagement.dto;

import com.Homework.CollegeManagement.entities.type.AdmissionStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public class AdmissionRecordDTO {

    private Long id;

    private LocalDate admissionDate;

    private Integer fees;

    @Enumerated(value = EnumType.STRING)
    private AdmissionStatus admissionStatus;


}
