package com.week3.Hibernate_Spring_Boot_Data_JPA.repositories;

import com.week3.Hibernate_Spring_Boot_Data_JPA.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductRepository, Long> {



}
