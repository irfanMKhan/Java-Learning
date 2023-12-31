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
@Table(name = "tbl_learning_configuration_types")
public class ConfigurationType extends AbstractDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator_configuration_type")
    @SequenceGenerator(name = "id_generator_configuration_type", initialValue = 1, allocationSize = 1)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private List<ConfigurationData> configurationDataList;

}
