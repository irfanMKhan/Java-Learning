package com.topic.module.userManagement.repository.implementation.user.provider;

import com.topic.module.userManagement.model.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User, Long> {
}
