package com.rfindustries.accounting.entities;

import com.rfindustries.accounting.constants.EntityDefinition;
import com.rfindustries.corejdbc.entities.BaseJDBCEntity;
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
@Table(EntityDefinition.TABLE_INVOICE_HEADER)
@NoArgsConstructor
public class InvoiceHeaderEntity extends BaseJDBCEntity {

    private Byte type;
    private String code;
    private Integer number;
    private LocalDateTime dateTime;
    private Long accountingId;
    private Long accountingYearId;
    private Long ledgerAccountId;
    private BigDecimal totalBase;
    private BigDecimal totalTaxes;
    private BigDecimal total;

}
