package com.rfindustries.shared.commons.dto;

import com.rfindustries.core.dto.BaseJDBCDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TaxDTO extends BaseJDBCDTO {
    private String code;
    private String name;
}
