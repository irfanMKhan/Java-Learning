package com.topic.module.userManagement.repository.implementation.user;

import com.topic.module.userManagement.repository.UserRepository;
import com.topic.module.userManagement.repository.implementation.user.provider.UserRepositoryJPA;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepositoryImplementation implements UserRepository {

    private final UserRepositoryJPA userRepositoryJPA;

}
