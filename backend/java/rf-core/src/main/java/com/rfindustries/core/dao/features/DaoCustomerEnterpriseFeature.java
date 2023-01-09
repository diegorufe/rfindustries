package com.rfindustries.core.dao.features;

import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;

import java.util.Objects;

public interface DaoCustomerEnterpriseFeature<ENTITY extends BaseEntity<PK>, PK> {

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
}
