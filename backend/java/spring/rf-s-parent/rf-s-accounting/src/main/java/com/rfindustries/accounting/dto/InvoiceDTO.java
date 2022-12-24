package com.rfindustries.accounting.dto;

import com.rfindustries.core.dto.BaseHeaderLineDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class InvoiceDTO extends BaseHeaderLineDTO<InvoiceHeaderDTO, InvoiceLineDTO, OptionInvoiceDTO> {
}
