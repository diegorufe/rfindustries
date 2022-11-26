package com.rfindustries.accounting.entities;

import com.rfindustries.corejdbc.entities.BaseJDBCEntity;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;


@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(AccountingYearEntityDefinition.TABLE)
public class AccountingYearEntity extends BaseJDBCEntity {

    private String code;
    private String name;
    private Long accountingId;
    private LocalDate startDate;
    private LocalDate endDate;

}
