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
@Table(name = "tbl_learning_configuration_data")
public class ConfigurationData extends AbstractDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator_configuration_data")
    @SequenceGenerator(name = "id_generator_configuration_data", initialValue = 1)
    private Long id;

    private String value;

    private String text;

    private String remarks;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private ConfigurationType configurationType;
}
