package com.rfindustries.corejdbc.config;

import com.rfindustries.core.constansts.RFConstants;
import com.rfindustries.corejdbc.dao.BAseJDBCCrudRespositoryImpl;
import com.rfindustries.corejdbc.factory.BaseJDBCRespositoryFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories(
        basePackages = RFConstants.PACKAGE_COMPONENT_SCAN,
        repositoryBaseClass = BAseJDBCCrudRespositoryImpl.class,
        repositoryFactoryBeanClass = BaseJDBCRespositoryFactoryBean.class
)
public class DatabaseConfig {
}
