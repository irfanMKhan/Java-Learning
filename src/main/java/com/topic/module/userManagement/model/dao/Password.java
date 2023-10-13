package com.topic.module.userManagement.model.dao;

import com.topic.module.userManagement.model.AbstractDAO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_learning_passwords")
public class Password extends AbstractDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator_password")
    @SequenceGenerator(name = "id_generator_password", initialValue = 1)
    private Long id;

    private String hashed;

    private Long failedAttempt;

}
