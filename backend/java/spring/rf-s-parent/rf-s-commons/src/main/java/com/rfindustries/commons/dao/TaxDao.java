package com.rfindustries.commons.dao;

import com.rfindustries.commons.entities.TaxEntity;
import com.rfindustries.corejdbc.dao.BaseJDBCCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxDao extends BaseJDBCCrudRepository<TaxEntity> {
}
