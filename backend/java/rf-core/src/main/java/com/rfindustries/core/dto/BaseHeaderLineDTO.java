package com.rfindustries.core.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class BaseHeaderLineDTO<HEADER extends BaseDTO, LINE extends BaseDTO, OPTION extends BaseOptionHeaderLineDTO> implements BaseDTO {
    private HEADER header;
    private List<LINE> lines;
    private OPTION options;
}
