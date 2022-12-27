package com.rfindustries.accounting.dto;

import com.rfindustries.core.dto.BaseJDBCDTO;
import com.rfindustries.shared.accounting.InvoiceLineType;
import com.rfindustries.shared.commons.dto.TaxVersionDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class InvoiceLineDTO extends BaseJDBCDTO {

    private LocalDateTime dateTime;
    private InvoiceLineType type;
    private InvoiceHeaderDTO invoiceHeader;
    private LedgerAccountDTO ledgerAccount;
    private Integer number;
    private String description;
    private BigDecimal amount;
    private BigDecimal total;
    private Set<TaxVersionDTO> taxVersions;
    
}
