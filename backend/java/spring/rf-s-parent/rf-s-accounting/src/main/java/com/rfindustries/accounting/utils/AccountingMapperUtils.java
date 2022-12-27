package com.rfindustries.accounting.utils;

import com.rfindustries.accounting.dto.*;
import com.rfindustries.accounting.entities.*;
import com.rfindustries.shared.accounting.InvoiceLineType;
import com.rfindustries.shared.utils.SharedMapperUtils;

public final class AccountingMapperUtils {

    private AccountingMapperUtils() {
        // NOT implemented
    }

    public static AccountingEntity toAccountingEntity(AccountingDTO dto) {
        return AccountingEntity.builder()
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

    public static AccountingDTO toAccountingDTO(AccountingEntity entity) {
        return AccountingDTO.builder()
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

    public static AccountingYearEntity toAccountingYearEntity(AccountingYearDTO dto) {
        return AccountingYearEntity.builder()
                .id(dto.getId())
                .businessCustomerId(dto.getBusinessCustomerId())
                .enterpriseId(dto.getEnterpriseId())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .userCreatedAtId(dto.resolverUserCreatedAtId())
                .userUpdatedAtId(dto.resolverUserUpdatedAtId())
                .code(dto.getCode())
                .name(dto.getName())
                .accountingId(resolveAccountingId(dto))
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();
    }

    public static AccountingYearDTO toAccountingYearDTO(AccountingYearEntity entity) {
        return AccountingYearDTO.builder()
                .id(entity.getId())
                .businessCustomerId(entity.getBusinessCustomerId())
                .enterpriseId(entity.getEnterpriseId())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .userCreatedAtId(entity.getUserCreatedAtId())
                .userUpdatedAtId(entity.getUserUpdatedAtId())
                .code(entity.getCode())
                .name(entity.getName())
                .accounting(
                        AccountingDTO.builder()
                                .id(entity.getAccountingId())
                                .build()
                )
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .build();
    }


    private static Long resolveAccountingId(AccountingYearDTO dto) {
        return dto.getAccounting() != null && dto.getAccounting().getId() != null ? dto.getAccounting().getId() : null;
    }

    public static LedgerAccountEntity toLedgerAccountEntity(LedgerAccountDTO dto) {
        return LedgerAccountEntity.builder()
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

    public static LedgerAccountDTO toLedgerAccountDTO(LedgerAccountEntity entity) {
        return LedgerAccountDTO.builder()
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

    public static InvoiceHeaderEntity toInvoiceHeaderEntity(InvoiceHeaderDTO dto) {
        return InvoiceHeaderEntity.builder()
                .id(dto.getId())
                .businessCustomerId(dto.getBusinessCustomerId())
                .enterpriseId(dto.getEnterpriseId())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .userCreatedAtId(dto.resolverUserCreatedAtId())
                .userUpdatedAtId(dto.resolverUserUpdatedAtId())
                .code(dto.getCode())
                .number(dto.getNumber())
                .dateTime(dto.getDateTime())
                .accountingId(dto.getAccounting() == null ? null : dto.getAccounting().getId())
                .accountingYearId(dto.getAccountingYear() == null ? null : dto.getAccountingYear().getId())
                .ledgerAccountId(dto.getLedgerAccount() == null ? null : dto.getLedgerAccount().getId())
                .build();
    }

    public static InvoiceHeaderDTO toInvoiceHeaderDTO(InvoiceHeaderEntity entity) {
        return InvoiceHeaderDTO.builder()
                .id(entity.getId())
                .businessCustomerId(entity.getBusinessCustomerId())
                .enterpriseId(entity.getEnterpriseId())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .userCreatedAtId(entity.getUserCreatedAtId())
                .userUpdatedAtId(entity.getUserUpdatedAtId())
                .code(entity.getCode())
                .number(entity.getNumber())
                .dateTime(entity.getDateTime())
                .accounting(AccountingDTO.builder().id(entity.getAccountingId()).build())
                .accountingYear(AccountingYearDTO.builder().id(entity.getAccountingYearId()).build())
                .ledgerAccount(LedgerAccountDTO.builder().id(entity.getLedgerAccountId()).build())
                .build();
    }

    public static InvoiceLineEntity toInvoiceLineEntity(InvoiceLineDTO dto) {
        return InvoiceLineEntity.builder()
                .id(dto.getId())
                .businessCustomerId(dto.getBusinessCustomerId())
                .enterpriseId(dto.getEnterpriseId())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .userCreatedAtId(dto.resolverUserCreatedAtId())
                .userUpdatedAtId(dto.resolverUserUpdatedAtId())
                .invoiceHeaderId(dto.getInvoiceHeader() == null ? null : dto.getInvoiceHeader().getId())
                .ledgerAccountId(dto.getLedgerAccount() == null ? null : dto.getLedgerAccount().getId())
                .dateTime(dto.getDateTime())
                .type(dto.getType().getType())
                .number(dto.getNumber())
                .amount(dto.getAmount())
                .total(dto.getTotal())
                .description(dto.getDescription())
                .taxVersions(SharedMapperUtils.taxVersionsToIds(dto.getTaxVersions()))
                .build();
    }

    public static InvoiceLineDTO toInvoiceLineDTO(InvoiceLineEntity entity) {
        return InvoiceLineDTO.builder()
                .id(entity.getId())
                .businessCustomerId(entity.getBusinessCustomerId())
                .enterpriseId(entity.getEnterpriseId())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .userCreatedAtId(entity.getUserCreatedAtId())
                .userUpdatedAtId(entity.getUserUpdatedAtId())
                .invoiceHeader(InvoiceHeaderDTO.builder().id(entity.getInvoiceHeaderId()).build())
                .ledgerAccount(LedgerAccountDTO.builder().id(entity.getLedgerAccountId()).build())
                .dateTime(entity.getDateTime())
                .type(InvoiceLineType.getByType(entity.getType()))
                .taxVersions(SharedMapperUtils.idsToTaxVersionDTOs(entity.getTaxVersions()))
                .build();
    }
}
