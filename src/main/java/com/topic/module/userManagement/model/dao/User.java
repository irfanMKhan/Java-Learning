package com.topic.module.userManagement.model.dao;

import com.topic.module.userManagement.model.AbstractDAO;
import com.topic.module.userManagement.model.security.CustomGrantedAuthority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_learning_users")
public class User extends AbstractDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator_user")
    @SequenceGenerator(name = "id_generator_user", initialValue = 1)
    private Long id;

    private String username;
    private String firstName;
    private String lastName;

    private String email;
    private String mobile;
    private String occupation;
    private String companyName;
    private Boolean isTokenExpired;
    private Boolean isLocked;

    private List<CustomGrantedAuthority> authorities;

}
