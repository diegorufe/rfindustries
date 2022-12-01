package com.rfindustries.accounting.dao;

import com.rfindustries.accounting.entities.AccountingEntity;
import com.rfindustries.corejdbc.dao.BaseJDBCCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingDao extends BaseJDBCCrudRepository<AccountingEntity> {
}
