package com.rfindustries.commons.dto;

import com.rfindustries.commons.entities.mappings.entitymappings.TaxVersionWithTaxMapping;
import com.rfindustries.shared.commons.constants.TaxVersionType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TaxVersionDTO extends com.rfindustries.shared.commons.dto.TaxVersionDTO {

    public static TaxVersionDTO fromTaxVersionWithTaxMapping(TaxVersionWithTaxMapping taxVersionWithTaxMapping) {
        return taxVersionWithTaxMapping == null
                ? null
                : builder()
                .id(taxVersionWithTaxMapping.getTaxVersion().getId())
                .type(TaxVersionType.findByType(taxVersionWithTaxMapping.getTaxVersion().getType()))
                .value(taxVersionWithTaxMapping.getTaxVersion().getValue())
                .startDate(taxVersionWithTaxMapping.getTaxVersion().getStartDate())
                .tax(TaxDTO.builder()
                        .id(taxVersionWithTaxMapping.getTax().getId())
                        .code(taxVersionWithTaxMapping.getTax().getCode())
                        .name(taxVersionWithTaxMapping.getTax().getName())
                        .build())
                .build();
    }
}
