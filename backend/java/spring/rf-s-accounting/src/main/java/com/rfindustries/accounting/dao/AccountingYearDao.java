package com.rfindustries.accounting.dao;

import com.rfindustries.accounting.entities.AccountingYearEntity;
import com.rfindustries.corejdbc.dao.BaseJDBCCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingYearDao extends BaseJDBCCrudRepository<AccountingYearEntity> {
}
