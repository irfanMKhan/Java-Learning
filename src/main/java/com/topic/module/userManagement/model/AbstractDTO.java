package com.topic.module.userManagement.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AbstractDTO {

    private Boolean isActive;


    private String createdBy;

    private LocalDateTime createdDate;

    private Long longCreatedDate;


    private String updatedBy;

    private LocalDateTime updatedDate;

    private Long longUpdatedDate;


    private Boolean isDeleted;

    private String deletedBy;

    private LocalDateTime deletedDate;

    private Long longDeletedDate;

}
