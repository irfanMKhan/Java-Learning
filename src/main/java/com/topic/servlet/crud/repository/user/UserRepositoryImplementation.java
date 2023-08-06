package com.topic.servlet.crud.repository.user;

import com.topic.servlet.crud.repository.USERS_REPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRepositoryImplementation {

    private final USERS_REPO usersRepo;
}
