package com.rfindustries.core.dao;

import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.entities.Column;

import java.util.Map;
import java.util.Objects;

public interface BaseDao<ENTITY extends BaseEntity<PK>, PK> {
    default <T> void audit(T userId, ENTITY entity, boolean create) {
        Objects.requireNonNull(entity);
        entity.audit(userId, create);
    }

//    Map<String, Column> getColumns();
}
