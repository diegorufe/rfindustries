package com.rfindustries.corejdbc.entities;

import com.rfindustries.core.entities.BaseEntity;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public  class BaseJDBCEntity implements BaseEntity<Long> {

    @Id
    private Long id;
    private Integer userCreatedAtId;
    private Integer userUpdatedAtId;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
