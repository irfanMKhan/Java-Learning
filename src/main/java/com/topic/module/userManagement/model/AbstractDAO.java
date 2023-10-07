package com.topic.module.userManagement.model;


import com.topic.module.userManagement.model.dto.UserDTO;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

@Data
@MappedSuperclass
public abstract class AbstractDAO {

    private Boolean isActive;


    private Long createdBy;

    private LocalDateTime createdDate;

    private Long longCreatedDate;


    private Long updatedBy;

    private LocalDateTime updatedDate;

    private Long longUpdatedDate;


    private Boolean isDeleted;

    private Long deletedBy;

    private LocalDateTime deletedDate;

    private Long longDeletedDate;

    public AbstractDAO() {
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zdt = ZonedDateTime.of(now, ZoneId.systemDefault());
        long longDate = zdt.toInstant().toEpochMilli();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDTO user = new UserDTO();
        if (Objects.nonNull(authentication)) {
            user = (UserDTO) authentication.getPrincipal();
        }

        this.setIsActive(true);
        this.setIsDeleted(false);
        this.setCreatedDate(now);
        this.setLongCreatedDate(longDate);
        this.setCreatedBy(user.getId());
    }

}
