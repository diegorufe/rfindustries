package com.rfindustries.accounting.dao;

import com.rfindustries.accounting.entities.InvoiceHeaderEntity;
import com.rfindustries.corejdbc.dao.BaseJDBCCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceHeaderDao extends BaseJDBCCrudRepository<InvoiceHeaderEntity> {
}
