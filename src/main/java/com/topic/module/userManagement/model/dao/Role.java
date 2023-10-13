package com.topic.module.userManagement.model.dao;

import com.topic.module.userManagement.model.AbstractDAO;
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
@Table(name = "tbl_learning_roles")
public class Role extends AbstractDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator_role")
    @SequenceGenerator(name = "id_generator_role", initialValue = 1)
    private Long id;

    private String name;
    private String description;
    private Long priority;

    @OneToMany(fetch = FetchType.LAZY)
    private List<User> user;

}
