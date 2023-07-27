package com.topic.module.userManagement.model.dto;

import com.topic.module.userManagement.model.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO extends AbstractDTO {

    private Long id;
    private String name;
    private String description;
    private Long priority;
    private Long userId;


    public RoleDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public RoleDTO(Long id, String name, String description, Long priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
    }
}
