package com.topic.module.userManagement.repository;

import com.topic.module.userManagement.model.dao.Role;
import com.topic.module.userManagement.model.dao.User;

import java.util.List;

public interface RoleRepository {

    List<Role> findRoleListByUser(User user);

}
