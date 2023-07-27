package com.lbs.repository;

import com.lbs.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends JpaRepository<Test, Long> {
    Test findByIdAndName(Long id, String name);
}
