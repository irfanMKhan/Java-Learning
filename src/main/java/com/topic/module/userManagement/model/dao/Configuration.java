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
@Table(name = "tbl_learning_configurations")
public class Configuration extends AbstractDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator_configuration")
    @SequenceGenerator(name = "id_generator_configuration", initialValue = 1)
    private Long id;

    private String key;

    private String value;

}
