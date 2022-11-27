package com.rfindustries.accounting.dto;

import com.rfindustries.corejdbc.dto.BaseJDBCDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class AccountingDTO extends BaseJDBCDTO {

    private String code;
    private String name;

}
