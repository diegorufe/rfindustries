package com.rfindustries.preferences.dao;

import com.rfindustries.coremongo.dao.BaseReactiveMongoRepository;
import com.rfindustries.preferences.entities.BrowserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BrowserDao extends BaseReactiveMongoRepository<BrowserEntity> {
}
