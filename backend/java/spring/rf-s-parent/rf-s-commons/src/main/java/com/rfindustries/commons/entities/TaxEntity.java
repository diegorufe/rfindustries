package com.rfindustries.commons.entities;

import com.rfindustries.commons.constants.EntitiesDefinition;
import com.rfindustries.corejdbc.entities.BaseJDBCEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.relational.core.mapping.Table;


@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Table(EntitiesDefinition.TABLE_TAX)
@NoArgsConstructor
public class TaxEntity extends BaseJDBCEntity {

    private String code;
    private String name;

}
