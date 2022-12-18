package com.rfindustries.core.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class BaseJDBCUserDTO extends BaseUserDTO {
    private Integer id;
}
