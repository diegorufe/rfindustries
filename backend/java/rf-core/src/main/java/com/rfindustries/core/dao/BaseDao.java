package com.rfindustries.core.dao;

import com.rf.collections.utils.CollectionUtils;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface BaseDao<ENTITY extends BaseEntity<PK>, PK> {
    default <T> void audit(T userId, ENTITY entity, boolean create) {
        Objects.requireNonNull(entity);
        entity.audit(userId, create);
    }

    default ENTITY insert(BaseCommonsParameters baseCommonsParameters, ENTITY entity) {
        ENTITY result = null;
        if (entity != null) {
            List<ENTITY> entities = this.insertAll(baseCommonsParameters, List.of(entity));

            if (CollectionUtils.isNotEmpty(entities)) {
                result = entities.get(0);
            }
        }

        return result;
    }

    List<ENTITY> insertAll(BaseCommonsParameters baseCommonsParameters, List<ENTITY> entities);

    default ENTITY update(BaseCommonsParameters baseCommonsParameters, ENTITY entity) {
        ENTITY result = null;
        if (entity != null) {
            List<ENTITY> entities = this.updateAll(baseCommonsParameters, List.of(entity));

            if (CollectionUtils.isNotEmpty(entities)) {
                result = entities.get(0);
            }
        }

        return result;
    }

    List<ENTITY> updateAll(BaseCommonsParameters baseCommonsParameters, List<ENTITY> entities);

    void delete(ENTITY entity);

    default boolean isBusinessCustomerRequired() {
        return true;
    }


    default boolean isEnterpriseRequired() {
        return true;
    }

    default void resolveBusinessCustomer(BaseCommonsParameters baseCommonsParameters, ENTITY entity) {
        if (isBusinessCustomerRequired()) {
            entity.resolveBusinessCustomer(baseCommonsParameters.getBusinessCustomerIdCastToDesire());
        }
    }

    default void resolveEnterprise(BaseCommonsParameters baseCommonsParameters, ENTITY entity) {
        if (isEnterpriseRequired()) {
            entity.resolveEnterprise(baseCommonsParameters.getEnterpriseIdCastToDesire());
        }
    }

    default Optional<ENTITY> findById(PK id){
        return Optional.empty();
    }
}
