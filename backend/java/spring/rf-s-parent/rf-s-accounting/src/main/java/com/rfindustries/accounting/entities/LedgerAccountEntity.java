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
@Table(EntityDefinition.TABLE_LEDGER_ACCOUNT)
@NoArgsConstructor
public class LedgerAccountEntity extends BaseJDBCEntity {

    private String code;
    private String name;

}
