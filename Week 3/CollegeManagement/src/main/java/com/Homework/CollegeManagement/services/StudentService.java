package com.Homework.CollegeManagement.services;

import com.Homework.CollegeManagement.Repositories.StudentRepository;
import com.Homework.CollegeManagement.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentById(Long studentId){
        return studentRepository.findById(studentId).orElseThrow();
    }







}
