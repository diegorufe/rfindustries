package com.rfindustries.corejdbc.entities;

import com.rfindustries.core.entities.BaseEntity;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class BaseJDBCEntity implements BaseEntity<Long> {

    @Id
    private Long id;
    private Integer userCreatedAtId;
    private Integer userUpdatedAtId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long businessCustomerId;
    private Long enterpriseId;


    @Override
    public <T> void resolveBusinessCustomer(T businessCustomerId) {
        this.businessCustomerId = (Long) businessCustomerId;
    }

    @Override
    public <T> void resolveEnterprise(T enterpriseId) {
        this.enterpriseId = (Long) enterpriseId;
    }

    @Override
    public void auditCreatedAt(LocalDateTime localDateTime) {
        this.createdAt = localDateTime;
    }

    @Override
    public void auditUpdatedAt(LocalDateTime localDateTime) {
        this.updatedAt = localDateTime;
    }

    @Override
    public <T> void auditUserCreatedAt(T userId) {
        this.userCreatedAtId = (Integer) userId;
    }

    @Override
    public <T> void auditUserUpdatedAt(T userId) {
        this.userUpdatedAtId = (Integer) userId;
    }
}
