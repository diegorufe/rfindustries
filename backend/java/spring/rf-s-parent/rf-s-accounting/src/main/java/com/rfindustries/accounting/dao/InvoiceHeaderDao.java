package com.rfindustries.accounting.dao;

import com.rfindustries.accounting.constants.EntityDefinition;
import com.rfindustries.accounting.entities.InvoiceHeaderEntity;
import com.rfindustries.corejdbc.dao.BaseJDBCCrudRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface InvoiceHeaderDao extends BaseJDBCCrudRepository<InvoiceHeaderEntity> {

    @Query("UPDATE RF_ACCOUNTING_INVOICE_HEADERS " +
            "SET TOTAL_BASE = :TOTAL_BASE, " +
            "TOTAL_TAXES = :TOTAL_TAXES, " +
            "TOTAL = :TOTAL " +
            "WHERE ID = :ID")
    int updateTotals(
            @Param(EntityDefinition.ID) Long id,
            @Param(EntityDefinition.TOTAL_BASE) BigDecimal totalBase,
            @Param(EntityDefinition.TOTAL_TAXES) BigDecimal totalTaxes,
            @Param(EntityDefinition.TOTAL) BigDecimal total
    );
}
