package com.rfindustries.coremongo.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.rfindustries.core.constansts.RFConstants;
import com.rfindustries.coremongo.dao.BaseReactiveMongoRepositoryImpl;
import com.rfindustries.coremongo.factory.BaseMongoRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories(
        basePackages = RFConstants.PACKAGE_COMPONENT_SCAN,
        repositoryBaseClass = BaseReactiveMongoRepositoryImpl.class,
        repositoryFactoryBeanClass = BaseMongoRepositoryFactoryBean.class
)
@Configuration
public class MongoConfig extends AbstractReactiveMongoConfiguration {

    @Value("${mongo.databaseName}")
    private String databaseName;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create();
    }


    @Override
    protected String getDatabaseName() {
        return this.databaseName;
    }
}
