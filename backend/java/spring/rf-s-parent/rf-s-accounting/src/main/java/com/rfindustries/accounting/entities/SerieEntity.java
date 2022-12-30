package com.rfindustries.accounting.entities;

import com.rfindustries.accounting.constants.EntityDefinition;
import com.rfindustries.corejdbc.entities.BaseJDBCEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Table;


@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Table(EntityDefinition.TABLE_SERIE)
@NoArgsConstructor
public class SerieEntity extends BaseJDBCEntity {

    private Long accountingId;
    private Long accountingYearId;
    private Byte type;
    private String code;
    private Integer number;
    private String name;
    
}
