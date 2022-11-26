package com.rfindustries.corejdbc.entities;

import com.rfindustries.core.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseJDBCEntity implements BaseEntity<Long> {

    @Id
    private Long id;
    private Integer userCreatedAtId;
    private Integer userUpdatedAtId;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
