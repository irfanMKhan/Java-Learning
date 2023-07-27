package com.topic.module.userManagement.repository.implementation.role.provider;

import com.topic.module.userManagement.model.dao.Role;
import com.topic.module.userManagement.model.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepositoryJPA extends JpaRepository<Role, Long> {

    List<Role> findAllByUser_IdAndIsActiveIsTrue(Long user_id);

}
