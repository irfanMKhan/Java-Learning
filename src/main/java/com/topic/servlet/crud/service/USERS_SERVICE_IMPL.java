package com.topic.servlet.crud.service;

import com.topic.servlet.crud.model.TBL_USERS;
import com.topic.servlet.crud.repository.USERS_REPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class USERS_SERVICE_IMPL implements USERS_SERVICE {
    private final USERS_REPO users_repo;
    @Override
    public Integer saveUser(TBL_USERS user){
        TBL_USERS tbl_users = users_repo.save(user);
        return tbl_users.getId();
    }

    @Override
    public Optional<String> getEmployeeName(String username){
        List<TBL_USERS> a =users_repo.findByUsername(username);
        return null;
    }
}
