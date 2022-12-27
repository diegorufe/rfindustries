package com.rfindustries.commons.utils;

import com.rfindustries.commons.dto.TaxDTO;
import com.rfindustries.commons.dto.TaxVersionDTO;
import com.rfindustries.commons.entities.TaxEntity;
import com.rfindustries.commons.entities.TaxVersionEntity;
import com.rfindustries.commons.entities.mappers.entities.TaxVersionWithTaxEntity;
import com.rfindustries.shared.commons.constants.TaxVersionType;

public final class CommonsMapperUtils {

    private CommonsMapperUtils(){
        // NOT Implemented
    }

    public static TaxVersionDTO fromTaxVersionWithTaxEntity(TaxVersionWithTaxEntity taxVersionWithTaxEntity) {
        return taxVersionWithTaxEntity == null
                ? null
                : TaxVersionDTO.builder()
                .id(taxVersionWithTaxEntity.getTaxVersion().getId())
                .type(TaxVersionType.findByType(taxVersionWithTaxEntity.getTaxVersion().getType()))
                .value(taxVersionWithTaxEntity.getTaxVersion().getValue())
                .startDate(taxVersionWithTaxEntity.getTaxVersion().getStartDate())
                .tax(TaxDTO.builder()
                        .id(taxVersionWithTaxEntity.getTax().getId())
                        .code(taxVersionWithTaxEntity.getTax().getCode())
                        .name(taxVersionWithTaxEntity.getTax().getName())
                        .build())
                .build();
    }

    public static TaxEntity toTaxEntity(TaxDTO dto) {
        return TaxEntity.builder()
                .id(dto.getId())
                .businessCustomerId(dto.getBusinessCustomerId())
                .enterpriseId(dto.getEnterpriseId())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .userCreatedAtId(dto.resolverUserCreatedAtId())
                .userUpdatedAtId(dto.resolverUserUpdatedAtId())
                .code(dto.getCode())
                .name(dto.getName())
                .build();
    }

    public static TaxDTO toTaxDTO(TaxEntity entity) {
        return TaxDTO.builder()
                .id(entity.getId())
                .businessCustomerId(entity.getBusinessCustomerId())
                .enterpriseId(entity.getEnterpriseId())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .userCreatedAtId(entity.getUserCreatedAtId())
                .userUpdatedAtId(entity.getUserUpdatedAtId())
                .code(entity.getCode())
                .name(entity.getName())
                .build();
    }

    public static TaxVersionEntity toTaxVersionEntity(TaxVersionDTO dto) {
        return TaxVersionEntity.builder()
                .id(dto.getId())
                .businessCustomerId(dto.getBusinessCustomerId())
                .enterpriseId(dto.getEnterpriseId())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .userCreatedAtId(dto.resolverUserCreatedAtId())
                .userUpdatedAtId(dto.resolverUserUpdatedAtId())
                .startDate(dto.getStartDate())
                .type(dto.getType() == null ? null : dto.getType().getType())
                .value(dto.getValue())
                .build();
    }

    public static TaxVersionDTO toTaxVersionDTO(TaxVersionEntity entity) {
        return TaxVersionDTO.builder()
                .id(entity.getId())
                .businessCustomerId(entity.getBusinessCustomerId())
                .enterpriseId(entity.getEnterpriseId())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .userCreatedAtId(entity.getUserCreatedAtId())
                .userUpdatedAtId(entity.getUserUpdatedAtId())
                .startDate(entity.getStartDate())
                .type(TaxVersionType.findByType(entity.getType()))
                .value(entity.getValue())
                .build();
    }
}
