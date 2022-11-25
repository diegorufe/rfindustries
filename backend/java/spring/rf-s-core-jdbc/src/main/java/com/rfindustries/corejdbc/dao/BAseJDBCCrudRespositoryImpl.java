package com.rfindustries.corejdbc.dao;

import com.rfindustries.core.entities.BaseEntity;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.repository.support.SimpleJdbcRepository;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional(
        readOnly = true
)
public class BAseJDBCCrudRespositoryImpl<ENTITY extends BaseEntity<Long>> extends SimpleJdbcRepository<ENTITY, Long> implements BaseJDBCCrudRepository<ENTITY> {

    public BAseJDBCCrudRespositoryImpl(JdbcAggregateOperations entityOperations, PersistentEntity<ENTITY, ?> entity, JdbcConverter converter) {
        super(entityOperations, entity, converter);
    }
}
