package com.topic.module.userManagement.model.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private Long id;

    private String jwt;

    private String username;

    private List<String> roles;

    private String type;

    private boolean passwordExpireFlag;

    private boolean passwordAlertFlag;

}
