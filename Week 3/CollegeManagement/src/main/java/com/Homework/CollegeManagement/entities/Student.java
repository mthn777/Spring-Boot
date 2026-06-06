package com.Homework.CollegeManagement.entities;


import com.Homework.CollegeManagement.entities.type.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    //format : YYYY-MM-dd
    private LocalDate dob;

    private Long contact;

    private String email;

    @OneToOne(mappedBy = "student")
    private AdmissionRecord admissionRecord;

    @ManyToMany
    @JoinTable(name = "student_professor")
    private List<Professor> professorList = new LinkedList<>();

    @ManyToMany
    @JoinTable(name = "student_subject")
    private List<Subject> subjectList;




//    @ManyToMany
//    private List<Subject> subjectList;
//
//    @ManyToMany
//    private List<Professor> professorList;


//    @OneToOne(mappedBy = "student")
//    private AdmissionRecord admissionRecord;




}
