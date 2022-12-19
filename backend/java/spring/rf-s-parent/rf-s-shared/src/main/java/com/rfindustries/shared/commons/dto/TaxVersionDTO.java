package com.rfindustries.shared.commons.dto;

import com.rfindustries.core.dto.BaseJDBCDTO;
import com.rfindustries.shared.proto.Tax;
import com.rfindustries.shared.proto.TaxVersion;
import com.rfindustries.shared.utils.ProtoUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TaxVersionDTO extends BaseJDBCDTO {
    private LocalDate startDate;
    private BigDecimal rate;
    private Long taxId;
    private TaxDTO tax;

    public static TaxVersionDTO fromTaxVersion(TaxVersion taxVersion){
        return TaxVersionDTO.builder()
                .id(taxVersion.getId())
                .startDate(ProtoUtils.fromGoogleDate(taxVersion.getStarDate()))
                .rate(ProtoUtils.fromGoogleDecimal(taxVersion.getRate()))
                .taxId(taxVersion.getTaxId())
                .tax(TaxDTO.fromTax(taxVersion.getTax()))
                .businessCustomerId(taxVersion.getBusinessCustomerId())
                .enterpriseId(taxVersion.getEnterpriseId())
                .build();
    }
}
