package com.Homework.CollegeManagement.dto;

import com.Homework.CollegeManagement.entities.type.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public class StudentDTO {

    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    //format : YYYY-MM-dd
    private LocalDate dob;

    private Long contact;

    private String email;


}
