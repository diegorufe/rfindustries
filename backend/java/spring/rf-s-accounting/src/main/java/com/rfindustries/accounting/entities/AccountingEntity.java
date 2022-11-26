package com.rfindustries.accounting.entities;

import com.rfindustries.corejdbc.entities.BaseJDBCEntity;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;


@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(AccountingEntityDefinition.TABLE)
public class AccountingEntity extends BaseJDBCEntity {

    private String code;
    private String name;

}