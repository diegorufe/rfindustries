package com.rfindustries.core.entities;

import java.time.LocalDateTime;

public interface BaseEntity<PK> {

    default <T> void auditUserCreatedAt(T userId) {
        // NOT Implemented
    }

    default <T> void auditUserUpdatedAt(T userId) {
        // NOT Implemented
    }

    default void auditCreatedAt(LocalDateTime localDateTime) {
        // NOT Implemented
    }

    default void auditUpdatedAt(LocalDateTime localDateTime) {
        // NOT Implemented
    }

    default <T> void audit(T userId, boolean create) {
        LocalDateTime now = LocalDateTime.now();

        if (create) {
            this.auditCreatedAt(now);
            this.auditUserCreatedAt(userId);
        }

        this.auditUpdatedAt(now);
        this.auditUserUpdatedAt(userId);
    }

    default <T> void resolveBusinessCustomer(T businessCustomerId){

    }

    default <T> void resolveEnterprise(T enterpriseId){

    }
}
