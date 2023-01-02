package com.rfindustries.shared.commons.dto;

import com.rfindustries.core.dto.BaseJDBCDTO;
import com.rfindustries.shared.commons.constants.TaxVersionType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TaxVersionDTO extends BaseJDBCDTO {
    private LocalDate startDate;
    private BigDecimal value;
    private TaxVersionType type;
    private TaxDTO tax;
}
