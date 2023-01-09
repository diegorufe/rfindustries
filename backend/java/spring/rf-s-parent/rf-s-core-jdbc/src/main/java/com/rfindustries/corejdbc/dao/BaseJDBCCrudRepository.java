package com.rfindustries.corejdbc.dao;

import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@NoRepositoryBean
public interface BaseJDBCCrudRepository<ENTITY extends BaseEntity<Long>> extends CrudRepository<ENTITY, Long>, BaseDao<ENTITY, Long> {

    @Transactional
    @Override
    default Mono<ENTITY> updateEntity(BaseCommonsParameters baseCommonsParameters, ENTITY entity) {
        return BaseDao.super.updateEntity(baseCommonsParameters, entity);
    }

    @Transactional
    @Override
    default Mono<ENTITY> insertEntity(BaseCommonsParameters baseCommonsParameters, ENTITY entity) {
        return BaseDao.super.insertEntity(baseCommonsParameters, entity);
    }

}
