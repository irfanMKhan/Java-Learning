package com.topic.servlet.crud.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;


@Entity
@Getter
@Setter
@Table(name = "TBL_USERS")
@NoArgsConstructor
@AllArgsConstructor
public class TBL_USERS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String employee_name;
    private Integer employee_id;
    private String user_role;
    private String user_priviledge;
}
