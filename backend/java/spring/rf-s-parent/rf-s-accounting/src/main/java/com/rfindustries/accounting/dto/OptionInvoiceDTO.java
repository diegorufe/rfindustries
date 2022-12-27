package com.rfindustries.accounting.dto;

import com.rfindustries.core.dto.BaseOptionHeaderLineDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OptionInvoiceDTO extends BaseOptionHeaderLineDTO {
}
