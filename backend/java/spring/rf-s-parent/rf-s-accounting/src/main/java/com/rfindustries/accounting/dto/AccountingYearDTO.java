package com.rfindustries.accounting.dto;

import com.rfindustries.core.dto.BaseJDBCDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AccountingYearDTO extends BaseJDBCDTO {
    private String code;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private AccountingDTO accounting;


}
