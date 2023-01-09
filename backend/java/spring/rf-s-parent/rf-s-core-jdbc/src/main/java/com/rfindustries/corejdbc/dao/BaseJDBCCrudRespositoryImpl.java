package com.rfindustries.corejdbc.dao;

import com.rf.collections.utils.CollectionUtils;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.repository.support.SimpleJdbcRepository;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.StreamSupport;

@Transactional(
        readOnly = true
)
public class BaseJDBCCrudRespositoryImpl<ENTITY extends BaseEntity<Long>> extends SimpleJdbcRepository<ENTITY, Long> implements BaseJDBCCrudRepository<ENTITY> {

    public BaseJDBCCrudRespositoryImpl(JdbcAggregateOperations entityOperations, PersistentEntity<ENTITY, ?> entity, JdbcConverter converter) {
        super(entityOperations, entity, converter);
    }


    private Flux<ENTITY> insertUpdateAll(BaseCommonsParameters baseCommonsParameters, List<ENTITY> entities, boolean create) {
        Flux<ENTITY> result = null;
        if (CollectionUtils.isNotEmpty(entities)) {
            entities.forEach(entity -> {
                this.audit(baseCommonsParameters.getUserId(), entity, create);
                this.resolveBusinessCustomer(baseCommonsParameters, entity);
                this.resolveEnterprise(baseCommonsParameters, entity);
            });
            entities = StreamSupport.stream(this.saveAll(entities).spliterator(), false).toList();
            result = Flux.just(entities.toArray(CollectionUtils.instanceArray((Class<ENTITY>) entities.get(0).getClass(), entities.size())));
        }
        return result;
    }

    @Transactional
    @Override
    public Flux<ENTITY> insertAllEntities(BaseCommonsParameters baseCommonsParameters, List<ENTITY> entities) {
        return this.insertUpdateAll(baseCommonsParameters, entities, true);
    }

    @Transactional
    @Override
    public Flux<ENTITY> updateAllEntities(BaseCommonsParameters baseCommonsParameters, List<ENTITY> entities) {
        return this.insertUpdateAll(baseCommonsParameters, entities, false);
    }

    @Override
    public Mono<Boolean> deleteEntity(ENTITY entity) {
        this.delete(entity);
        return Mono.just(true);
    }

}
