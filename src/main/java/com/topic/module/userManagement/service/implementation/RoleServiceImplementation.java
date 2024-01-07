package com.topic.module.userManagement.service.implementation;

import com.topic.module.userManagement.model.dao.Role;
import com.topic.module.userManagement.model.dao.User;
import com.topic.module.userManagement.repository.RoleRepository;
import com.topic.module.userManagement.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImplementation implements RoleService {

    private final RoleRepository roleRepository;

    public List<Role> findRoleListByUser(User user) {
        return roleRepository.findRoleListByUser(user);
    }

}
