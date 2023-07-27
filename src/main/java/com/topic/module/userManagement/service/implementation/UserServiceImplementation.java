package com.topic.module.userManagement.service.implementation;

import com.topic.module.userManagement.model.dao.Role;
import com.topic.module.userManagement.model.dao.User;
import com.topic.module.userManagement.model.dto.UserDTO;
import com.topic.module.userManagement.repository.UserRepository;
import com.topic.module.userManagement.service.RoleService;
import com.topic.module.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final RoleService roleService;

    private final UserRepository userRepository;

    public User findByUsername(String username) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        List<Role> userRoles = roleService.findRoleListByUser(user);
        return UserDTO.build(null, null);
    }
}
