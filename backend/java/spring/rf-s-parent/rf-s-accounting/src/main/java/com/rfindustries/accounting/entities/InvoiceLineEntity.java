package com.rfindustries.accounting.entities;

import com.rfindustries.accounting.constants.EntityDefinition;
import com.rfindustries.corejdbc.entities.BaseJDBCEntity;
import com.rfindustries.shared.accounting.InvoiceHeaderType;
import com.rfindustries.shared.accounting.InvoiceLineType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Table(EntityDefinition.TABLE_INVOICE_LINE)
@NoArgsConstructor
public class InvoiceLineEntity extends BaseJDBCEntity {

    private Byte type;
    private Long invoiceHeaderId;
    private Long ledgerAccountId;
    private Integer number;
    private String description;
    private BigDecimal amount;
    private BigDecimal total;
    private String taxVersions;

}
