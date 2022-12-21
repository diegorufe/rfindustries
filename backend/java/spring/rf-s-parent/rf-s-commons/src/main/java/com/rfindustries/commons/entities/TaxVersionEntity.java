package com.rfindustries.commons.entities;

import com.rfindustries.commons.constants.EntityDefinition;
import com.rfindustries.corejdbc.entities.BaseJDBCEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Table(EntityDefinition.TABLE_TAX_VERSION)
@NoArgsConstructor
public class TaxVersionEntity extends BaseJDBCEntity {

    private LocalDate startTime;
    private BigDecimal value;
    private Byte type;

}
