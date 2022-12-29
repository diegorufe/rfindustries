package com.rfindustries.core.dto;

import com.rfindustries.core.features.CalculationType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
public class BaseOptionHeaderLineDTO {
    private Integer lineIndex;
    private Set<CalculationType> calculationTypes;
}
