package com.rfindustries.corejdbc.factory;

import com.rfindustries.corejdbc.dao.BaseJDBCCrudRepository;
import com.rfindustries.corejdbc.entities.BaseJDBCEntity;
import org.springframework.data.jdbc.repository.support.JdbcRepositoryFactoryBean;

public class BaseJDBCRespositoryFactoryBean<REPO extends BaseJDBCCrudRepository<ENTITY>,ENTITY extends BaseJDBCEntity> extends JdbcRepositoryFactoryBean<REPO, ENTITY, Long> {
    public BaseJDBCRespositoryFactoryBean(Class repositoryInterface) {
        super(repositoryInterface);
    }
}
