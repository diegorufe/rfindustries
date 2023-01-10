package com.rfindustries.coremongo.factory;

import com.rfindustries.coremongo.dao.BaseReactiveMongoRepository;
import com.rfindustries.coremongo.entities.BaseMongoEntity;
import org.springframework.data.mongodb.repository.support.ReactiveMongoRepositoryFactoryBean;

public class BaseMongoRepositoryFactoryBean<REPO extends BaseReactiveMongoRepository<ENTITY>,ENTITY extends BaseMongoEntity> extends ReactiveMongoRepositoryFactoryBean<REPO, ENTITY, String> {
    public BaseMongoRepositoryFactoryBean(Class repositoryInterface) {
        super(repositoryInterface);
    }
}
