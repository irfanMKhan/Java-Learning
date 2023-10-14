package com.topic.module.userManagement.service;

import com.topic.module.userManagement.model.dao.Role;
import com.topic.module.userManagement.model.dao.User;

import java.util.List;

public interface RoleService {

    List<Role> findRoleListByUser(User user);

}
