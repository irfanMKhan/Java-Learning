package com.topic.servlet.crud.service;

import com.topic.servlet.crud.model.TBL_USERS;
import com.topic.servlet.crud.repository.USERS_REPO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class USERS_SERVICE_IMPL implements USERS_SERVICE {
    private final USERS_REPO users_repo;

    Map<Integer,Integer> v = new HashMap<>();

    private final List<Integer> a = new ArrayList<>();
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
