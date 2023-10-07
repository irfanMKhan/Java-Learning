package com.topic.module.userManagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    Long id;
    String roleName;
    String description;
    Long user_id;
    Boolean isActive;
    Boolean isDelete;
    Long priority;
    String createdBy;
    LocalDateTime createdDate;
    String updatedBy;
    LocalDateTime updatedDate;
    String deletedBy;
    LocalDateTime deletedDate;


    public RoleDTO(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }

    public RoleDTO(Long id, String roleName, String description, Long priority) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
        this.priority = priority;
    }
}
