package com.rfindustries.accounting.dto;

import com.rfindustries.accounting.constants.EntityDefinition;
import com.rfindustries.core.dto.BaseJDBCDTO;
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
@NoArgsConstructor
public class InvoiceHeaderDTO extends BaseJDBCDTO {

    private InvoiceType type;
    private String code;
    private Integer number;
    private LocalDateTime dateTime;
    private AccountingDTO accounting;
    private AccountingYearDTO accountingYear;
    private LedgerAccountDTO ledgerAccount;

}
