package com.rfindustries.core.dao;

import com.rfindustries.core.dao.features.DaoAuditFeature;
import com.rfindustries.core.dao.features.DaoCustomerEnterpriseFeature;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface BaseDao<ENTITY extends BaseEntity<PK>, PK> extends
        DaoAuditFeature<ENTITY, PK>,
        DaoCustomerEnterpriseFeature<ENTITY, PK> {

    default Mono<ENTITY> insertEntity(BaseCommonsParameters baseCommonsParameters, ENTITY entity) {
        Mono<ENTITY> result = null;
        if (entity != null) {
            Flux<ENTITY> entities = this.insertAllEntities(baseCommonsParameters, List.of(entity));
            result = entities.collect(Collectors.reducing((i1, i2) -> i1))
                    .map(Optional::get);
        }

        return result;
    }

    Flux<ENTITY> insertAllEntities(BaseCommonsParameters baseCommonsParameters, List<ENTITY> entities);


    default Mono<ENTITY> updateEntity(BaseCommonsParameters baseCommonsParameters, ENTITY entity) {
        Mono<ENTITY> result = null;
        if (entity != null) {
            Flux<ENTITY> entities = this.updateAllEntities(baseCommonsParameters, List.of(entity));
            result = entities.collect(Collectors.reducing((i1, i2) -> i1))
                    .map(Optional::get);
        }

        return result;
    }

    Flux<ENTITY> updateAllEntities(BaseCommonsParameters baseCommonsParameters, List<ENTITY> entities);

    Mono<Boolean> deleteEntity(ENTITY entity);

    default Mono<ENTITY> findEntityById(PK id){
        return Mono.empty();
    }
}
