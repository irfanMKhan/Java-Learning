package com.topic.servlet.crud.repository;

import com.topic.servlet.crud.model.TBL_USERS;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface USERS_REPO extends JpaRepository<TBL_USERS, Long> {
    List<TBL_USERS> findByUsername(String employee_name);

    Page<TBL_USERS> findAll(Pageable pageable);
}
