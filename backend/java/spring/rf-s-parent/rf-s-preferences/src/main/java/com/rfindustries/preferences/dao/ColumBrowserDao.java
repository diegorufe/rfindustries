package com.rfindustries.preferences.dao;

import com.rfindustries.coremongo.dao.BaseReactiveMongoRepository;
import com.rfindustries.preferences.entities.ColumnBrowserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ColumBrowserDao extends BaseReactiveMongoRepository<ColumnBrowserEntity> {
}
