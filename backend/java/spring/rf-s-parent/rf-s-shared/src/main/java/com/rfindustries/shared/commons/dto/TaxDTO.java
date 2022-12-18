package com.rfindustries.shared.commons.dto;

import com.rfindustries.core.dto.BaseJDBCDTO;
import com.rfindustries.shared.proto.Tax;
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

    public static TaxDTO fromTax(Tax tax){
        return TaxDTO.builder()
                .id(tax.getId())
                .code(tax.getCode())
                .name(tax.getName())
                .businessCustomerId(tax.getBusinessCustomerId())
                .enterpriseId(tax.getEnterpriseId())
                .build();
    }
}
