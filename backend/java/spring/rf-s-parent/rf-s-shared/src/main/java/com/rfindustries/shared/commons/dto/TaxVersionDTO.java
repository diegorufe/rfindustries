package com.rfindustries.shared.commons.dto;

import com.rf.collections.utils.CollectionUtils;
import com.rf.collections.utils.StringUtils;
import com.rfindustries.core.constansts.RFConstants;
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
import java.util.stream.Collectors;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TaxVersionDTO extends BaseJDBCDTO {
    private LocalDate startDate;
    private BigDecimal value;
    private TaxVersionType type;
    private Long taxId;
    private TaxDTO tax;

    public static TaxVersionDTO fromTaxVersion(TaxVersion taxVersion) {
        return builder()
                .id(taxVersion.getId())
                .startDate(ProtoUtils.fromGoogleDate(taxVersion.getStarDate()))
                .value(ProtoUtils.fromGoogleDecimal(taxVersion.getValue()))
                .taxId(taxVersion.getTaxId())
                .tax(TaxDTO.fromTax(taxVersion.getTax()))
                .businessCustomerId(taxVersion.getBusinessCustomerId())
                .enterpriseId(ProtoUtils.getLongValue(taxVersion.getEnterpriseId()))
                .type(TaxVersionType.findByType(taxVersion.getType().getNumber()))
                .build();
    }

    public static String taxVersionsToStringIds(Collection<TaxVersionDTO> taxVersions) {
        return taxVersions == null ? null : CollectionUtils.collectionToStringIds(taxVersions.stream().map(TaxVersionDTO::getId).toList());
    }

    public static Set<TaxVersionDTO> idsToTaxVersionDTOs(String taxVersions) {
        return CollectionUtils.idsStringToSet(taxVersions, id-> TaxVersionDTO.builder().id(Long.valueOf(id)).build());
    }
}
