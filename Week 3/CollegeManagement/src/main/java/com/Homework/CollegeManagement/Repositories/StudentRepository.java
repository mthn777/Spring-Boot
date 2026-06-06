package com.Homework.CollegeManagement.Repositories;

import com.Homework.CollegeManagement.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {



}
