package com.rfindustries.accounting.dto;

import com.rfindustries.core.dto.BaseJDBCDTO;
import com.rfindustries.shared.accounting.InvoiceHeaderType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class InvoiceHeaderDTO extends BaseJDBCDTO {

    private InvoiceHeaderType type;
    private String code;
    private Integer number;
    private LocalDateTime dateTime;
    private AccountingDTO accounting;
    private AccountingYearDTO accountingYear;
    private LedgerAccountDTO ledgerAccount;

}
