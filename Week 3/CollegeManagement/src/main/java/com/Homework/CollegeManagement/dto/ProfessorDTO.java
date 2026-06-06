package com.Homework.CollegeManagement.dto;

import com.Homework.CollegeManagement.entities.type.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class ProfessorDTO {

    private Long id;

    private String name;

    private String email;

    private Long salary;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;


}
