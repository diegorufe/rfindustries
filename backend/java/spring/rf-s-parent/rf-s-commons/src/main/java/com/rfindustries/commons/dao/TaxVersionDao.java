package com.rfindustries.commons.dao;

import com.rfindustries.commons.entities.TaxVersionEntity;
import com.rfindustries.corejdbc.dao.BaseJDBCCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxVersionDao extends BaseJDBCCrudRepository<TaxVersionEntity> {
}
