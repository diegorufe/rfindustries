package com.rfindustries.corejdbc.dao;

import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.entities.BaseEntity;
import com.rfindustries.core.features.BaseCommonsParameters;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@NoRepositoryBean
public interface BaseJDBCCrudRepository<ENTITY extends BaseEntity<Long>> extends CrudRepository<ENTITY, Long>, BaseDao<ENTITY, Long> {

    @Transactional
    @Override
    default ENTITY update(BaseCommonsParameters baseCommonsParameters, ENTITY entity) {
        return BaseDao.super.update(baseCommonsParameters, entity);
    }

    @Transactional
    @Override
    default ENTITY insert(BaseCommonsParameters baseCommonsParameters, ENTITY entity) {
        return BaseDao.super.insert(baseCommonsParameters, entity);
    }

    @Override
    Optional<ENTITY> findById(Long aLong);
}
