package com.rfindustries.accounting.entities;

import com.rfindustries.corejdbc.entities.BaseJDBCEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;


@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Table(TaxEntityDefinition.TABLE)
public class TaxEntity extends BaseJDBCEntity {

    private String code;
    private String name;
    private LocalDate startDate;

}
