package com.rfindustries.corejdbc.dao;

import com.rf.collections.utils.CollectionUtils;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.repository.support.SimpleJdbcRepository;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.StreamSupport;

@Transactional(
        readOnly = true
)
public class BAseJDBCCrudRespositoryImpl<ENTITY extends BaseEntity<Long>> extends SimpleJdbcRepository<ENTITY, Long> implements BaseJDBCCrudRepository<ENTITY> {

    public BAseJDBCCrudRespositoryImpl(JdbcAggregateOperations entityOperations, PersistentEntity<ENTITY, ?> entity, JdbcConverter converter) {
        super(entityOperations, entity, converter);
    }


    private List<ENTITY> insertUpdateAll(BaseCommonsParameters baseCommonsParameters, List<ENTITY> entities, boolean create) {
        if (CollectionUtils.isNotEmpty(entities)) {
            entities.forEach(entity -> this.audit(baseCommonsParameters.getUserId(), entity, create));
            entities = StreamSupport.stream(this.saveAll(entities).spliterator(), false).toList();
        }
        return entities;
    }

    @Transactional
    @Override
    public List<ENTITY> insertAll(BaseCommonsParameters baseCommonsParameters, List<ENTITY> entities) {
        return this.insertUpdateAll(baseCommonsParameters, entities, true);
    }

    @Transactional
    @Override
    public List<ENTITY> updateAll(BaseCommonsParameters baseCommonsParameters, List<ENTITY> entities) {
        return this.insertUpdateAll(baseCommonsParameters, entities, false);
    }

}
