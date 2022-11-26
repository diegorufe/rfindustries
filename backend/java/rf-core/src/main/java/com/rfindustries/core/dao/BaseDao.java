package com.rfindustries.core.dao;

import com.rf.collections.utils.CollectionUtils;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.entities.Column;
import com.rfindustries.core.features.BaseCommonsParameters;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface BaseDao<ENTITY extends BaseEntity<PK>, PK> {
    default <T> void audit(T userId, ENTITY entity, boolean create) {
        Objects.requireNonNull(entity);
        entity.audit(userId, create);
    }

    default ENTITY insert(BaseCommonsParameters baseCommonsParameters, ENTITY entity){
        ENTITY result = null;
        if(entity != null){
            List<ENTITY> entities = this.insertAll(baseCommonsParameters, List.of(entity));

            if(CollectionUtils.isNotEmpty(entities)){
                result = entities.get(0);
            }
        }

        return result;
    }

    List<ENTITY> insertAll(BaseCommonsParameters baseCommonsParameters, List<ENTITY> entities);

    default ENTITY update(BaseCommonsParameters baseCommonsParameters, ENTITY entity){
        ENTITY result = null;
        if(entity != null){
            List<ENTITY> entities = this.updateAll(baseCommonsParameters, List.of(entity));

            if(CollectionUtils.isNotEmpty(entities)){
                result = entities.get(0);
            }
        }

        return result;
    }

    List<ENTITY> updateAll(BaseCommonsParameters baseCommonsParameters, List<ENTITY> entities);

    void delete(ENTITY entity);
}
