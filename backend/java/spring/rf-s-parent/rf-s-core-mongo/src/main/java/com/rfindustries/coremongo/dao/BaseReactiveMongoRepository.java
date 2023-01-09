package com.rfindustries.coremongo.dao;

import com.rfindustries.core.dao.BaseDao;
import com.rfindustries.core.entities.BaseEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseReactiveMongoRepository<ENTITY extends BaseEntity<String>> extends ReactiveMongoRepository<ENTITY, String>, BaseDao<ENTITY, String> {



}
