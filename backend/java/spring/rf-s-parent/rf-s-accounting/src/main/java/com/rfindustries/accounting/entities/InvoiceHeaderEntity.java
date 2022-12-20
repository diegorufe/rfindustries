package com.rfindustries.accounting.entities;

import com.rfindustries.accounting.constants.EntityDefinition;
import com.rfindustries.corejdbc.entities.BaseJDBCEntity;
import com.rfindustries.shared.accounting.InvoiceType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Table(EntityDefinition.TABLE_INVOICE_HEADER)
@NoArgsConstructor
public class InvoiceHeaderEntity extends BaseJDBCEntity {

    private InvoiceType type;
    private String code;
    private Integer number;
    private LocalDateTime dateTime;
    private Long accountingId;
    private Long accountingYearId;
    private Long ledgerAccountId;

}
