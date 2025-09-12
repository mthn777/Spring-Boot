package com.week2.mvc.mvc.repositories;

import com.week2.mvc.mvc.entities.EmployeeEnitity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEnitity, Long> {


}
