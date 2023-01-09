package com.rfindustries.core.dao.features;

import com.rfindustries.core.entities.BaseEntity;

import java.util.Objects;

public interface DaoAuditFeature<ENTITY extends BaseEntity<PK>, PK> {

    default <T> void audit(T userId, ENTITY entity, boolean create) {
        Objects.requireNonNull(entity);
        entity.audit(userId, create);
    }
}
