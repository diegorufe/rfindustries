package com.rfindustries.accounting.dto;

import com.rfindustries.accounting.constants.SerieType;
import com.rfindustries.core.dto.BaseJDBCDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SerieDTO extends BaseJDBCDTO {

    private AccountingDTO accounting;
    private AccountingYearDTO accountingYear;
    private SerieType type;
    private String code;
    private Integer number;
    private String name;

}
