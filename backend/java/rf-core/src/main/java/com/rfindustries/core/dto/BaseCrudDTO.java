package com.rfindustries.core.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
public class BaseCrudDTO<PK> implements BaseDTO {
    private PK id;
    private Integer userCreatedAtId;
    private Integer userUpdatedAtId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private BaseJDBCUserDTO userCreatedAt;
    private BaseJDBCUserDTO userUpdatedAt;
    private Long businessCustomerId;
    private Long enterpriseId;

    @SuppressWarnings("unchecked")
    @Override
    public <T> T resolverUserCreatedAtId() {
        return (T) (userCreatedAt != null && userCreatedAt.getId() != null ? userCreatedAt.getId() : this.userCreatedAtId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T resolverUserUpdatedAtId() {
        return (T) (userUpdatedAt != null && userUpdatedAt.getId() != null ? userUpdatedAt.getId() : this.userUpdatedAtId);
    }
}
