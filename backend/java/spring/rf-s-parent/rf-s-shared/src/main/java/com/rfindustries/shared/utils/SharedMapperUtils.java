package com.rfindustries.shared.utils;

import com.rf.collections.utils.StringUtils;
import com.rfindustries.shared.commons.constants.TaxVersionType;
import com.rfindustries.shared.commons.dto.TaxDTO;
import com.rfindustries.shared.commons.dto.TaxVersionDTO;
import com.rfindustries.shared.proto.Tax;
import com.rfindustries.shared.proto.TaxVersion;

import java.util.Collection;
import java.util.Set;

import static com.rfindustries.shared.utils.ProtoUtils.*;

public final class SharedMapperUtils {

    private SharedMapperUtils() {
        // NOT implemented
    }

    public static TaxDTO fromTax(Tax tax) {
        return tax == null ? null : TaxDTO.builder()
                .id(tax.getId())
                .code(tax.getCode())
                .name(tax.getName())
                .businessCustomerId(tax.getBusinessCustomerId())
                .enterpriseId(ProtoUtils.getLongValue(tax.hasEnterpriseId() ? tax.getEnterpriseId() : null))
                .build();
    }

    public static TaxVersionDTO fromTaxVersion(TaxVersion taxVersion) {
        return TaxVersionDTO.builder()
                .id(taxVersion.getId())
                .startDate(fromGoogleDate(taxVersion.getStarDate()))
                .value(fromGoogleDecimal(taxVersion.getValue()))
                .tax(fromTax(taxVersion.getTax()))
                .businessCustomerId(taxVersion.getBusinessCustomerId())
                .enterpriseId(getLongValue(taxVersion.getEnterpriseId()))
                .type(TaxVersionType.findByType(taxVersion.getType().getNumber()))
                .build();
    }

    public static String taxVersionsToIds(Collection<TaxVersionDTO> taxVersions) {
        return taxVersions == null ? null : StringUtils.collectionToHashtagsIds(taxVersions.stream().map(TaxVersionDTO::getId).toList());
    }

    public static Set<TaxVersionDTO> idsToTaxVersionDTOs(String taxVersions) {
        return StringUtils.idsHashtagsToSet(taxVersions, id -> TaxVersionDTO.builder().id(Long.valueOf(id)).build());
    }
}
