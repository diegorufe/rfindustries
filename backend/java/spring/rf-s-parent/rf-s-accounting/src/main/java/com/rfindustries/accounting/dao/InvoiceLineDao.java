package com.rfindustries.accounting.dao;

import com.rfindustries.accounting.constants.EntityDefinition;
import com.rfindustries.accounting.entities.InvoiceLineEntity;
import com.rfindustries.corejdbc.dao.BaseJDBCCrudRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceLineDao extends BaseJDBCCrudRepository<InvoiceLineEntity> {

    @Query("SELECT * FROM " + EntityDefinition.TABLE_INVOICE_LINE + " WHERE " + EntityDefinition.INVOICE_HEADER_ID + " = :invoiceId ORDER BY " + EntityDefinition.NUMBER)
    List<InvoiceLineEntity> findAllByInvoiceId(@Param(EntityDefinition.INVOICE_HEADER_ID) Long invoiceId);
}
