package com.rfindustries.accounting.dto;

import com.rfindustries.corejdbc.dto.BaseJDBCDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AccountingDTO extends BaseJDBCDTO {

    private String code;
    private String name;

}
