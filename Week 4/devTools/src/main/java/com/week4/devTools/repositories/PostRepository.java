package com.week4.devTools.repositories;

import com.week4.devTools.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {




}
