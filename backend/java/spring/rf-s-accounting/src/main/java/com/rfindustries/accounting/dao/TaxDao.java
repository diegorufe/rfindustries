package com.rfindustries.accounting.dao;

import com.rfindustries.accounting.entities.TaxEntity;
import com.rfindustries.corejdbc.dao.BaseJDBCCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxDao extends BaseJDBCCrudRepository<TaxEntity> {
}
