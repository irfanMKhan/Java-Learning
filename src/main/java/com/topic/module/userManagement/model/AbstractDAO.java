package com.topic.module.userManagement.model;


import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
@MappedSuperclass
public abstract class AbstractDAO {

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

    public AbstractDAO() {
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zdt = ZonedDateTime.of(now, ZoneId.systemDefault());
        long longDate = zdt.toInstant().toEpochMilli();
        this.setLongCreatedDate(longDate);
        this.setCreatedDate(now);
    }

}
