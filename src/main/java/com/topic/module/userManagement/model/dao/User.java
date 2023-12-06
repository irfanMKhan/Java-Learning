package com.topic.module.userManagement.model.dao;

import com.topic.module.userManagement.model.AbstractDAO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_learning_users")
public class User extends AbstractDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator_user")
    @SequenceGenerator(name = "id_generator_user", initialValue = 1, allocationSize = 1)
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Role role;

}
