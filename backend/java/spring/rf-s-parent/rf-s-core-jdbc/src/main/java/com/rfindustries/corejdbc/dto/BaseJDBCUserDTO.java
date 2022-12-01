package com.rfindustries.corejdbc.dto;

import com.rfindustries.core.dto.BaseUserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class BaseJDBCUserDTO extends BaseUserDTO {
    private Integer id;
}
