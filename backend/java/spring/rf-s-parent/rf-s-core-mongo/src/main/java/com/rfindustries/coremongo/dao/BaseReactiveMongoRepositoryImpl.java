package com.rfindustries.coremongo.dao;

import com.rf.collections.utils.CollectionUtils;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class BaseReactiveMongoRepositoryImpl
        <ENTITY extends BaseEntity<String>>
        extends SimpleReactiveMongoRepository<ENTITY, String>
        implements BaseReactiveMongoRepository<ENTITY> {
    public BaseReactiveMongoRepositoryImpl(MongoEntityInformation<ENTITY, String> entityInformation, ReactiveMongoOperations mongoOperations) {
        super(entityInformation, mongoOperations);
    }

    private Flux<ENTITY> insertUpdateAll(BaseCommonsParameters baseCommonsParameters, List<ENTITY> entities, boolean create) {
        Flux<ENTITY> result = null;
        if (CollectionUtils.isNotEmpty(entities)) {
            entities.forEach(entity -> {
                this.audit(baseCommonsParameters.getUserId(), entity, create);
                this.resolveBusinessCustomer(baseCommonsParameters, entity);
                this.resolveEnterprise(baseCommonsParameters, entity);
            });
            result = this.saveAll(entities);
        }
        return result;
    }

    @Override
    public Flux<ENTITY> insertAllEntities(BaseCommonsParameters baseCommonsParameters, List<ENTITY> entities) {
        return this.insertUpdateAll(baseCommonsParameters, entities, true);
    }

    @Override
    public Flux<ENTITY> updateAllEntities(BaseCommonsParameters baseCommonsParameters, List<ENTITY> entities) {
        return this.insertUpdateAll(baseCommonsParameters, entities, false);
    }

    @Override
    public Mono<Boolean> deleteEntity(ENTITY entity) {
        this.delete(entity).block();
        return Mono.just(true);
    }
}
