package com.Homework.CollegeManagement.Repositories;

import com.Homework.CollegeManagement.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
