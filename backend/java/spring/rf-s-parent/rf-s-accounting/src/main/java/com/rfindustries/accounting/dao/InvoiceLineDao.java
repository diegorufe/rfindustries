package com.rfindustries.accounting.dao;

import com.rfindustries.accounting.constants.EntityDefinition;
import com.rfindustries.accounting.dto.InvoiceLineDTO;
import com.rfindustries.accounting.entities.InvoiceLineEntity;
import com.rfindustries.corejdbc.dao.BaseJDBCCrudRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface InvoiceLineDao extends BaseJDBCCrudRepository<InvoiceLineEntity> {

    @Query("SELECT il.*, " +
            "la.ID LA_ID, la.CODE LA_CODE, la.NAME LA_NAME " +
            "FROM RF_ACCOUNTING_INVOICE_LINES il " +
            "LEFT JOIN RF_ACCOUNTING_LEDGER_ACCOUNTS la ON la.ID = il.LEDGER_ACCOUNT_ID " +
            "WHERE il.INVOICE_HEADER_ID = :INVOICE_HEADER_ID ORDER BY il.NUMBER ")
    List<InvoiceLineDTO> findAllByInvoiceId(@Param(EntityDefinition.INVOICE_HEADER_ID) Long invoiceId);

    @Transactional
    @Query("DELETE FROM RF_ACCOUNTING_INVOICE_LINES il WHERE il.INVOICE_HEADER_ID = :INVOICE_HEADER_ID ")
    long deleteAllByInvoiceId(@Param(EntityDefinition.INVOICE_HEADER_ID) Long invoiceId);
}
