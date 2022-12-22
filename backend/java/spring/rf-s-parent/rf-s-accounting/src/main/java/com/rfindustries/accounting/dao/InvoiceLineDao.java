package com.rfindustries.accounting.dao;

import com.rfindustries.accounting.entities.InvoiceLineEntity;
import com.rfindustries.corejdbc.dao.BaseJDBCCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceLineDao extends BaseJDBCCrudRepository<InvoiceLineEntity> {
}
