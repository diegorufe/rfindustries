package com.rfindustries.shared.commons.dto;

import com.rf.collections.utils.StringUtils;
import com.rfindustries.core.dto.BaseJDBCDTO;
import com.rfindustries.shared.commons.constants.TaxVersionType;
import com.rfindustries.shared.proto.TaxVersion;
import com.rfindustries.shared.utils.ProtoUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TaxVersionDTO extends BaseJDBCDTO {
    private LocalDate startTime;
    private BigDecimal value;
    private TaxVersionType type;
    private Long taxId;
    private TaxDTO tax;

    public static TaxVersionDTO fromTaxVersion(TaxVersion taxVersion) {
        return builder()
                .id(taxVersion.getId())
                .startTime(ProtoUtils.fromGoogleDate(taxVersion.getStarDate()))
                .value(ProtoUtils.fromGoogleDecimal(taxVersion.getValue()))
                .taxId(taxVersion.getTaxId())
                .tax(TaxDTO.fromTax(taxVersion.getTax()))
                .businessCustomerId(taxVersion.getBusinessCustomerId())
                .enterpriseId(ProtoUtils.getLongValue(taxVersion.getEnterpriseId()))
                .type(TaxVersionType.findByType(taxVersion.getType().getNumber()))
                .build();
    }

    public static String taxVersionsToIds(Collection<TaxVersionDTO> taxVersions) {
        return taxVersions == null ? null : StringUtils.collectionToHashtagsIds(taxVersions.stream().map(TaxVersionDTO::getId).toList());
    }

    public static Set<TaxVersionDTO> idsToTaxVersionDTOs(String taxVersions) {
        return StringUtils.idsHashtagsToSet(taxVersions, id-> TaxVersionDTO.builder().id(Long.valueOf(id)).build());
    }
}
