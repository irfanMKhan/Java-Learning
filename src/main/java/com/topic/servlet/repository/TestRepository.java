package com.topic.servlet.repository;

import com.topic.servlet.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    Test findByIdAndName(Long id, String name);
}
