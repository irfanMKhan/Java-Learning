package com.topic.module.userManagement.model.payload.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChangePasswordRequest {

    private String username;

    private String email;

    private String password;

    private String oldPassword;

    private String newPassword;

}
