package com.Homework.CollegeManagement.Repositories;

import com.Homework.CollegeManagement.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
