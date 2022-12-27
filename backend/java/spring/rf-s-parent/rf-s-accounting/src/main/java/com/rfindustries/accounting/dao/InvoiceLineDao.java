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

    @Query("SELECT * FROM RF_ACCOUNTING_INVOICE_LINES WHERE INVOICE_HEADER_ID = :INVOICE_HEADER_ID ORDER BY number ")

    List<InvoiceLineEntity> findAllByInvoiceId(@Param(EntityDefinition.INVOICE_HEADER_ID) Long invoiceId);

    @Query("DELETE FROM RF_ACCOUNTING_INVOICE_LINES WHERE INVOICE_HEADER_ID = :INVOICE_HEADER_ID ")
    long deleteAllByInvoiceId(@Param(EntityDefinition.INVOICE_HEADER_ID) Long invoiceId);
}
