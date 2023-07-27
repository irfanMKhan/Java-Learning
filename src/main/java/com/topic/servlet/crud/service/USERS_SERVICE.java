package com.topic.servlet.crud.service;

import com.topic.servlet.crud.model.TBL_USERS;

import java.util.Optional;

public interface USERS_SERVICE {

    Integer saveUser(TBL_USERS user);
    Optional<String> getEmployeeName(String username);
}
