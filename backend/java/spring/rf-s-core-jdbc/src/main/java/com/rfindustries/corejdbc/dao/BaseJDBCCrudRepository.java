package com.rfindustries.corejdbc.dao;

import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.entities.BaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseJDBCCrudRepository<ENTITY extends BaseEntity<Long>> extends CrudRepository<ENTITY, Long>, BaseDao<ENTITY, Long> {

}
