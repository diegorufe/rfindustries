package com.rfindustries.accounting.dao;

import com.rfindustries.accounting.entities.LedgerAccountEntity;
import com.rfindustries.corejdbc.dao.BaseJDBCCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedgerAccountDao extends BaseJDBCCrudRepository<LedgerAccountEntity> {
}
