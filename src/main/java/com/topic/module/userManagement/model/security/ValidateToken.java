package com.topic.module.userManagement.model.security;

import lombok.Data;

@Data
public class ValidateToken {
    private Boolean status;
    private String subject;
    private String message;

    public ValidateToken() {
        this.setStatus(false);
    }

}
