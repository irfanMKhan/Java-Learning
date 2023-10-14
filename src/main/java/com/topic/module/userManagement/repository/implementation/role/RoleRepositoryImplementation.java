package com.topic.module.userManagement.repository.implementation.role;

import com.topic.module.userManagement.model.dao.Role;
import com.topic.module.userManagement.model.dao.User;
import com.topic.module.userManagement.repository.RoleRepository;
import com.topic.module.userManagement.repository.implementation.role.provider.RoleRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RoleRepositoryImplementation implements RoleRepository {
    private final RoleRepositoryJPA roleRepositoryJPA;

    public List<Role> findRoleListByUser(User user) {
        return roleRepositoryJPA.findAllByUser_IdAndIsActiveIsTrue(user.getId());
    }

}
